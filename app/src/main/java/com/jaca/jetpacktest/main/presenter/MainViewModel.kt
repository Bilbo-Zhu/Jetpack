package com.jaca.jetpacktest.main.presenter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jaca.jetpacktest.R
import com.jaca.jetpacktest.main.bean.MainTextData

enum class MainTextActionType(val value: Int) {
    GO_TO_SHARE_DATA_DEMO(0),
    GO_TO_LIVE_DATA_DEMO(1),
    GO_TO_DATA_BINDING_DEMO(2)
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    fun getMainList(): List<Any> {
        return listOf(
            MainTextData(
                content = getApplication<Application>().resources.getString(R.string.add_share_fragment),
                actionType = MainTextActionType.GO_TO_SHARE_DATA_DEMO.value
            ),
            MainTextData(
                content = getApplication<Application>().resources.getString(R.string.live_data_demo),
                actionType = MainTextActionType.GO_TO_LIVE_DATA_DEMO.value
            ),
            MainTextData(
                content = getApplication<Application>().resources.getString(R.string.data_binding_demo),
                actionType = MainTextActionType.GO_TO_DATA_BINDING_DEMO.value
            )
        )
    }
}