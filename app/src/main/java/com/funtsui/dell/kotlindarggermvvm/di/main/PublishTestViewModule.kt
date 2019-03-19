package com.funtsui.dell.kotlindarggermvvm.di.main

import android.arch.lifecycle.ViewModel
import com.funtsui.dell.kotlindarggermvvm.di.ViewModelKey
import com.funtsui.dell.kotlindarggermvvm.vm.HistroyViewModel
import com.ssf.tc.publish.vm.PublishTestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by zhg on 2019/3/19.
 */
@Module
internal  abstract class PublishTestViewModule{
    // 将View添加到Map
    @Binds
    @IntoMap
    @ViewModelKey(PublishTestViewModel::class)
    abstract fun bindPublishTestViewModel(vm: PublishTestViewModel): ViewModel
}