package com.jaca.jetpacktest.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.jaca.jetpacktest.MainActivity
import com.jaca.jetpacktest.R
import com.jaca.jetpacktest.`interface`.IMainCallBack
import com.jaca.jetpacktest.viewmodel.FragSharedViewModel
import com.jaca.jetpacktest.viewmodel.factory.FragSharedViewModelFactory

class ShareDataFragment : Fragment() {

    private lateinit var viewModel: FragSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener(view)
        initViewModel()
    }

    private fun initListener(view: View) {
        view.findViewById<TextView>(R.id.tv_go_receive).setOnClickListener {
            if (activity is MainActivity) {
                (activity as IMainCallBack).navigator2ReceiveDataFrag()
            }
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity(), FragSharedViewModelFactory()).get(
            FragSharedViewModel::class.java
        )
        viewModel.shareValue = "is from share frag"
    }

    override fun onPause() {
        super.onPause()
        println("zjnTest SharedFirstFragment onPause")
    }

    override fun onStop() {
        super.onStop()
        println("zjnTest SharedFirstFragment onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("zjnTest SharedFirstFragment onDestroy")
    }

    companion object {
        const val TAG = "ShareDataFragment"

        @JvmStatic
        fun newInstance() = ShareDataFragment()
    }
}