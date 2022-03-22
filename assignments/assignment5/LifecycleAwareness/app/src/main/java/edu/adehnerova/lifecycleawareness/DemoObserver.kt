@file:Suppress("DEPRECATION")

package edu.adehnerova.lifecycleawareness

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import edu.adehnerova.lifecycleawareness.ui.main.MainViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Suppress("DEPRECATION")
class DemoObserver : LifecycleObserver {
    private val LOG_TAG = "Observer"

    private var viewModel = MainViewModel
    //retrieving formatted time stamp
    val date = LocalDateTime.now().format(DateTimeFormatter.ISO_TIME)!!

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume")
        viewModel.setMsg("onResume was fired on " + date + "\n**************\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause")
        viewModel.setMsg("onPause was fired on " + date + "\n**************\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG, "onCreate")
        viewModel.setMsg("onCreate was fired on " + date)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG, "onStart")
        viewModel.setMsg("onStart was fired on " + date)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG, "onStop")
        viewModel.setMsg("onStop was fired on " + date)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG, "onDestroy")
        viewModel.setMsg("onDestroy was fired on " + date)
    }
}