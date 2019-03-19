package com.funtsui.dell.kotlindarggermvvm.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.funtsui.dell.kotlindarggermvvm.vm.SuperViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class JectPackFragment<T : ViewDataBinding>(
    private val layoutResID: Int,
    // click 列表
    vararg ids: Int = intArrayOf(0)
) : BaseFragment(layoutResID,*ids), LifecycleOwner {

    // mvvm
    protected lateinit var binding: T
    // 是否初始化过
    private var mInit = false

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appViewModelProvider: ViewModelProvider

    val viewModelProvider: ViewModelProvider by lazy {
        createViewModelProvider()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mInflate == null) {
            // 注入
            AndroidSupportInjection.inject(this)
            // dataBinding
            binding = DataBindingUtil.inflate(inflater, layoutResID, container, false)
            binding.setLifecycleOwner(this)
            // 记录布局，避免多次创建
            mInflate = binding.root
            // 初始化默认配置
            initDefaultConfig(savedInstanceState)
            // DataBinding
            // 注册
        }
        initClickEvent()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

    private fun initClickEvent() {
        if (!mInit) {
            mInit = true
            //初始化监听
            setClickViewId(mInflate)
        }
    }

    protected open fun createViewModelProvider(): ViewModelProvider {
        return SuperViewModelProvider(this, viewModelFactory, appViewModelProvider)
    }
}