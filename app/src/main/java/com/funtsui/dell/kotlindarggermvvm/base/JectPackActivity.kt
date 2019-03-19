package com.funtsui.dell.kotlindarggermvvm.base

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import com.funtsui.dell.kotlindarggermvvm.vm.SuperViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


//本类 基于androidjectpack+viewmodel+databing+darggerandroid
abstract class JectPackActivity<T : ViewDataBinding >(
    //设置布局id
    private val layoutResID:Int,
    //设置点击事件id 为事件id数组
    private vararg val ids:Int,
    //设置是否可以侧滑返回
    private val swapeBackLayoutEnable:Boolean=true,
    //状态栏颜色 沉浸式处理
    private val statusBarColor:Int =0,
    //状态栏的透明度(0-255)
    private val statusBarAlpha : Int =0
) : BaseActivity(layoutResID,*ids,swapeBackLayoutEnable =swapeBackLayoutEnable,statusBarColor = statusBarColor,statusBarAlpha = statusBarAlpha),
    HasSupportFragmentInjector {
    //基于mvvm +dargger 架构注入变量
    //最终初始化databing
    protected lateinit var binding: T

    //注入依赖的activity的fragment 依赖于dargger android
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appViewModelProvider: ViewModelProvider

    val viewModelProvider: ViewModelProvider by lazy {
         createViewModelProvider()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        //dargger 注入当前界面
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
    override fun setContentView() {
        // 初始化 Binding
        binding = DataBindingUtil.setContentView(this, layoutResID)
        //设置生命周期监听 rxlifecycle
        binding.setLifecycleOwner(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
    override fun supportFragmentInjector()=fragmentInjector

    protected fun createViewModelProvider():ViewModelProvider{
        return SuperViewModelProvider(this, viewModelFactory, appViewModelProvider)
    }

}