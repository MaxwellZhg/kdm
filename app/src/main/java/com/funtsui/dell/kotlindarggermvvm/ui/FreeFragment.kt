package com.funtsui.dell.kotlindarggermvvm.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.R
import com.funtsui.dell.kotlindarggermvvm.base.JectPackFragment
import com.funtsui.dell.kotlindarggermvvm.databinding.FreeFragmentBinding
import com.funtsui.dell.kotlindarggermvvm.vm.FreeViewModel

/**
 * Created by zhg on 2019/1/10.
 */
class FreeFragment : JectPackFragment<FreeFragmentBinding>(R.layout.free_fragment, R.id.detail) {
    private val viewModel by lazy {
        viewModelProvider.get(FreeViewModel::class.java)
    }

    override fun init(view: View?, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.detail -> {
                binding.tv.text="1111"
            }
        }
    }

}