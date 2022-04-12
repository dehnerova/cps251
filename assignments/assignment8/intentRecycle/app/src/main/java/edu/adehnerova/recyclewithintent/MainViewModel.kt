package edu.adehnerova.recyclewithintent

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        //whenever newInstance() is called elsewhere, we'll come here and retrieve this object of MVM
        fun newInstance() = MainViewModel()

        //create an array list of integers
        var intArray: ArrayList<ArrayList<Int>> = arrayListOf()
    }

    //create and randomize array values
    fun randomize(){
        //if array size is zero or array is null
        if (intArray.size == 0) {
            for (i in 0..7)
                intArray.add(arrayListOf((0..7).random(), (0..7).random(), (0..7).random()))
        }

    }
}

