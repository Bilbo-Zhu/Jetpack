package com.jaca.jetpacktest.demo.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.jaca.jetpacktest.R

class ReceiveDataFragment : Fragment() {

    private lateinit var viewModel: FragSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receive_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView(view)
    }

    /**
     * 1.ViewModelProvider(requireActivity()).get(FragSharedViewModel::class.java)
     * or ViewModelProvider(requireActivity(), FragSharedViewModelFactory()).get(FragSharedViewModel::class.java)
     * or ViewModelProvider(this, FragSharedViewModelFactory()).get(FragSharedViewModel::class.java)
     * 2. viewModel1: FragSharedViewModel by viewModels()
     * or
     * val viewModel: FragSharedViewModel by activityViewModels()
     */
    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity(), FragSharedViewModelFactory()).get(
            FragSharedViewModel::class.java
        )
    }

    private fun initView(view: View) {
        view.findViewById<TextView>(R.id.tv_receive_data).text = viewModel.shareValue
    }

    override fun onStart() {
        super.onStart()
        println("zjnTest ReceiveDataFragment onStart")
    }

    override fun onResume() {
        super.onResume()
        println("zjnTest ReceiveDataFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        println("zjnTest ReceiveDataFragment onPause")
    }

    override fun onStop() {
        super.onStop()
        println("zjnTest ReceiveDataFragment onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("zjnTest ReceiveDataFragment onDestroy")
    }

    companion object {
        const val TAG = "ReceiveDataFragment"

        @JvmStatic
        fun newInstance() = ReceiveDataFragment()
    }
}