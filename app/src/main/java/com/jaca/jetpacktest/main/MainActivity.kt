package com.jaca.jetpacktest.main

import android.os.Bundle
import com.jaca.jetpacktest.R
import com.jaca.jetpacktest.main.`interface`.IMainCallBack
import com.jaca.jetpacktest.base.BindingActivity
import com.jaca.jetpacktest.databinding.ActivityMainBinding
import com.jaca.jetpacktest.main.presenter.MainPresenter
import com.jaca.jetpacktest.main.provider.MainNavigatorProvider

class MainActivity : BindingActivity<ActivityMainBinding>(), IMainCallBack {

    private val mainPresenter: MainPresenter by lazy {
        MainPresenter()
    }
    private val mainNavigatorProvider: MainNavigatorProvider by lazy {
        MainNavigatorProvider(supportFragmentManager)
    }

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(mainPresenter)
        initBinding()
    }

    private fun initBinding() {
        binding.navigatorProvider = mainNavigatorProvider
    }

    override fun navigator2ReceiveDataFrag() {
        mainNavigatorProvider.navigator2ReceiveDataFrag()
    }
}