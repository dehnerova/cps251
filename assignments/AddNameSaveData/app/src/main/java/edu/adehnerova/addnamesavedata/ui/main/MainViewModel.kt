package edu.adehnerova.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var personName = ""
    private var nameList: ArrayList<String> = arrayListOf()

    fun getNames(): String {
        //iterating through array list
        var nameString = ""
        for (i in nameList)
            nameString += i

        return nameString
    }

    fun setName(value: String) {
        //adding name to array, followed by line return
        personName = "$value \n"
        nameList.add(personName)
    }

}