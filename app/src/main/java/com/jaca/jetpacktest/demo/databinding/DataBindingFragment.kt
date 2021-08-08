package com.jaca.jetpacktest.demo.databinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jaca.jetpacktest.R
import com.jaca.jetpacktest.base.BindingFragment
import com.jaca.jetpacktest.databinding.FragmentDataBindingBinding
import com.jaca.jetpacktest.demo.databinding.viewmodel.DataBindingViewModel

class DataBindingFragment : BindingFragment<FragmentDataBindingBinding>() {

    private val viewModel: DataBindingViewModel by lazy {
        ViewModelProvider(this).get(DataBindingViewModel::class.java)
    }

    override fun getLayoutResource(): Int = R.layout.fragment_data_binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
    }

    private fun initBinding() {
        binding.vm = viewModel
    }

    companion object {
        const val TAG = "DataBindingFragment"

        @JvmStatic
        fun newInstance() = DataBindingFragment()
    }
}