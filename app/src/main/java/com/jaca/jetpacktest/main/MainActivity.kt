package com.jaca.jetpacktest.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaca.jetpacktest.R
import com.jaca.jetpacktest.main.`interface`.IMainCallBack
import com.jaca.jetpacktest.base.BindingActivity
import com.jaca.jetpacktest.databinding.ActivityMainBinding
import com.jaca.jetpacktest.main.adapter.MainTextItemViewBinder
import com.jaca.jetpacktest.main.bean.MainTextData
import com.jaca.jetpacktest.main.presenter.MainViewModel
import com.jaca.jetpacktest.main.presenter.MainViewModelFactory
import com.jaca.jetpacktest.main.provider.MainNavigatorProvider
import me.drakeet.multitype.MultiTypeAdapter

class MainActivity : BindingActivity<ActivityMainBinding>(), IMainCallBack {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
    }
    private val mainNavigatorProvider: MainNavigatorProvider by lazy {
        MainNavigatorProvider(supportFragmentManager)
    }
    private val adapter: MultiTypeAdapter by lazy {
        MultiTypeAdapter()
    }

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        notifyDataChange()
    }

    private fun initBinding() {
        binding.navigatorProvider = mainNavigatorProvider
        val mainListRv = binding.rvMainList
        mainListRv.layoutManager = LinearLayoutManager(this)
        mainListRv.adapter = adapter
        adapter.register(MainTextData::class.java, MainTextItemViewBinder(mainNavigatorProvider))
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun notifyDataChange() {
        adapter.items = mainViewModel.getMainList()
        adapter.notifyDataSetChanged()
    }

    override fun navigator2ReceiveDataFrag() {
        mainNavigatorProvider.navigator2ReceiveDataFrag()
    }
}