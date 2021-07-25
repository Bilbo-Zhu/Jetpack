package com.jaca.jetpacktest.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainPresenter: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        //to do something
        println("zjnTest onStart success")
    }
}