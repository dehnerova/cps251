package edu.adehnerova.lifecycleawareness.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val LOG_TAG = "MainViewModel"

    companion object{
        //constant key variable
        const val log = "MainViewModel"

        var output: MutableLiveData<String> = MutableLiveData()
        var text = ""

        // @ liveData example
        fun setMsg(output: String){
            //
            text += "${output}\n"
            this.output.value = text
            Log.i(log, this.output.toString())
        }

    }
    // @ liveData example
    fun getMsg(): MutableLiveData<String> {
        Log.i(LOG_TAG, output.value.toString())
        return output

    }
}