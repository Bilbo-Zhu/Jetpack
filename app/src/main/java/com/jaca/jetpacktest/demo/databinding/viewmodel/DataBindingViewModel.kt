package com.jaca.jetpacktest.demo.databinding.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class DataBindingViewModel : ViewModel() {
    val content = ObservableField("Default")

    fun onChangeContentClick() {
        content.set("Content changed")
    }
}