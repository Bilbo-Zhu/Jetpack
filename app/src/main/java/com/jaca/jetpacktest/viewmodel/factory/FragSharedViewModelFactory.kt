package com.jaca.jetpacktest.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jaca.jetpacktest.viewmodel.FragSharedViewModel

class FragSharedViewModelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FragSharedViewModel() as T
    }
}