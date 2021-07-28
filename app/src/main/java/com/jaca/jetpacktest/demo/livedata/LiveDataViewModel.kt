package com.jaca.jetpacktest.demo.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel: ViewModel() {

    val clickValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
}