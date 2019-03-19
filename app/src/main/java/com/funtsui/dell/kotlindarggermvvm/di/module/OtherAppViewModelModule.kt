package com.funtsui.dell.kotlindarggermvvm.di.module

import android.arch.lifecycle.ViewModel
import com.funtsui.dell.kotlindarggermvvm.vm.OtherAppViewModel
import com.funtsui.dell.kotlindarggermvvm.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * 全局的ViewModel提供模块
 * Created by Hzz on 2018/8/22
 */
@Module
internal abstract class OtherAppViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(OtherAppViewModel::class)
    abstract fun bindAppViewModel(vm: OtherAppViewModel): ViewModel

}