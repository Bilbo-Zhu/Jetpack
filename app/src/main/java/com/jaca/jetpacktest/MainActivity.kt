package com.jaca.jetpacktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jaca.jetpacktest.`interface`.IMainCallBack
import com.jaca.jetpacktest.demo.livedata.LiveDataFragment
import com.jaca.jetpacktest.demo.viewmodel.ReceiveDataFragment
import com.jaca.jetpacktest.demo.viewmodel.ShareDataFragment
import com.jaca.jetpacktest.presenter.MainPresenter

class MainActivity : AppCompatActivity(), IMainCallBack {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainPresenter()
        lifecycle.addObserver(mainPresenter)

        initListener()
    }

    private fun initListener() {
        findViewById<TextView>(R.id.tv_add_share_frag).setOnClickListener {
            navigator2ShareDataFrag()
        }
        findViewById<TextView>(R.id.tv_live_data).setOnClickListener {
            showScreen(LiveDataFragment.newInstance(), LiveDataFragment.TAG)
        }
    }

    private fun navigator2ShareDataFrag() {
        showScreen(ShareDataFragment.newInstance(), ShareDataFragment.TAG)
    }

    override fun navigator2ReceiveDataFrag() {
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