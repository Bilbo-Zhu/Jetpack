package com.jaca.jetpacktest.demo.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jaca.jetpacktest.R

class LiveDataFragment : Fragment() {

    private lateinit var viewModel: LiveDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel(view)
        initListener(view)
    }

    private fun initViewModel(view: View) {
        viewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)
        viewModel.clickValue.observe(viewLifecycleOwner, Observer {
            view.findViewById<TextView>(R.id.tv_click_value).text = it.toString()
        })
    }

    private fun initListener(view: View) {
        view.findViewById<TextView>(R.id.tv_click).setOnClickListener {
            val clickValue = viewModel.clickValue.value
            viewModel.clickValue.value = clickValue?.plus(1)
        }
    }

    companion object {
        const val TAG = "LiveDataFragment"

        @JvmStatic
        fun newInstance() = LiveDataFragment()
    }
}