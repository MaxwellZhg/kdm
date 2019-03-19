package com.funtsui.dell.kotlindarggermvvm.ui

import android.os.Bundle
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.R
import com.funtsui.dell.kotlindarggermvvm.base.JectPackFragment
import com.funtsui.dell.kotlindarggermvvm.databinding.HistroyFragmentBinding
import com.funtsui.dell.kotlindarggermvvm.vm.HistroyViewModel

/**
 * Created by zhg on 2019/1/10.
 */
class HistoryFragment : JectPackFragment<HistroyFragmentBinding>(R.layout.histroy_fragment) {
    private val viewModel by lazy {
        viewModelProvider.get(HistroyViewModel::class.java)
    }

    override fun init(view: View?, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
    }
}