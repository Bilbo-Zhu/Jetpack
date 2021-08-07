package com.jaca.jetpacktest.main.provider

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.jaca.jetpacktest.R
import com.jaca.jetpacktest.demo.livedata.LiveDataFragment
import com.jaca.jetpacktest.demo.viewmodel.ReceiveDataFragment
import com.jaca.jetpacktest.demo.viewmodel.ShareDataFragment

class MainNavigatorProvider(
    private val supportFragmentManager: FragmentManager,
) {

    fun onAddShareFragClick() {
        showScreen(ShareDataFragment.newInstance(), ShareDataFragment.TAG)
    }

    fun onAddLiveDataFragClick() {
        showScreen(LiveDataFragment.newInstance(), LiveDataFragment.TAG)
    }

    fun navigator2ReceiveDataFrag() {
        showScreen(ReceiveDataFragment.newInstance(), ReceiveDataFragment.TAG)
    }

    private fun showScreen(fragment: Fragment, tag: String, isReplace: Boolean = false) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        val containerId = R.id.fl_root_view
        supportFragmentManager.findFragmentById(containerId)?.let { beginTransaction.hide(it) }
        if (isReplace) {
            beginTransaction.replace(containerId, fragment, tag).commit()
        } else {
            beginTransaction.add(containerId, fragment, tag).addToBackStack(tag).commit()
        }
    }
}