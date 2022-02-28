package edu.adehnerova.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var personName = ""
    private var nameList: ArrayList<String> = arrayListOf()

    fun setName(value: String) {
        personName = "$value \n"
        nameList.add(personName)
    }

    fun getNames(): String {

        var nameString = ""
        for (i in nameList)
            nameString += i

        return nameString
    }
}