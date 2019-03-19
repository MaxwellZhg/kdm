package com.funtsui.dell.kotlindarggermvvm.ui

import android.os.Bundle
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.R
import com.funtsui.dell.kotlindarggermvvm.base.JectPackFragment
import com.funtsui.dell.kotlindarggermvvm.databinding.PlayFragmentBinding
import com.funtsui.dell.kotlindarggermvvm.vm.PlayViewModel

/**
 * Created by zhg on 2019/1/10.
 */
class PlayFragment : JectPackFragment<PlayFragmentBinding>(R.layout.play_fragment) {
    private val viewModel by lazy {
        viewModelProvider.get(PlayViewModel::class.java)
    }

    override fun init(view: View?, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
    }

}