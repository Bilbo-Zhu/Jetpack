package com.jaca.jetpacktest.main.presenter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jaca.jetpacktest.R
import com.jaca.jetpacktest.main.bean.MainTextData

class MainViewModel(application: Application): AndroidViewModel(application) {

    fun getMainList(): List<Any> {
        return listOf(
            MainTextData(
                getApplication<Application>().resources.getString(R.string.add_share_fragment)
            ),
            MainTextData(
                getApplication<Application>().resources.getString(R.string.live_data_demo)
            )
        )
    }
}