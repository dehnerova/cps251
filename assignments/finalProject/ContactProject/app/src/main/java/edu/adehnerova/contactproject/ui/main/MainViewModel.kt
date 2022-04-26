package edu.adehnerova.contactproject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.adehnerova.contactproject.Contact
import edu.adehnerova.contactproject.ContactRepo

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepo = ContactRepo(application)
    private val fullContactList: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init{
        fullContactList = repository.allContacts
        searchResults = repository.searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return fullContactList
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun findContact(contactName: String) {
        repository.findContact(contactName)
    }

    fun descSort(): MutableLiveData<List<Contact>> {
        repository.descSort()
        return searchResults
    }
    //ascending
    fun ascSort(): MutableLiveData<List<Contact>>? {
        repository.ascSort()
        return searchResults
    }

    fun getSearchResults(): MutableLiveData<List<Contact>>{
        return searchResults
    }

    fun deleteContact(contactId: Int) {
        repository.deleteContact(contactId)
    }


}