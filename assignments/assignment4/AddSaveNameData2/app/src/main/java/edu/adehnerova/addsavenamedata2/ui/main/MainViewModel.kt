package edu.adehnerova.addsavenamedata2.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    var inputName: MutableLiveData<String> = MutableLiveData()
    private var nameList: ArrayList<String?> = arrayListOf()
    var currentName: MutableLiveData<String> = MutableLiveData()

    fun addName() {
        nameList.add(inputName.value)
    }

    fun displayNames() {
        //display the name as it is being typed
        currentName.value = inputName.value

        //loop through list and display them below
        for (i in nameList)
            currentName.value += "\n$i"
    }
}