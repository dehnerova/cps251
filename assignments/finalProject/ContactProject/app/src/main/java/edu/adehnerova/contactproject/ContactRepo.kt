package edu.adehnerova.contactproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepo(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDAO: ContactDAO?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDAO = db?.contactDAO()
        allContacts = contactDAO?.getAllContacts()
    }

    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }

    private suspend fun asyncInsert(contacts: Contact) {
        contactDAO?.insertContact(contacts)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int) {
        contactDAO?.deleteContact(id)
    }

    fun findContact(contactName: String) {
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncFind(contactName).await()
        }
    }

    private suspend fun asyncFind(contactName: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDAO?.findContact(contactName)
        }

    //descending
    fun descSort() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncDescContact().await()
        }
    }

    private suspend fun asyncDescContact(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDAO?.descSort()
        }

    fun ascSort(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncAscContact().await()
        }
    }

    private suspend fun asyncAscContact(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDAO?.ascSort()
        }

}