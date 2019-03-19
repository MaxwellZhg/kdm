package com.funtsui.dell.kotlindarggermvvm.di.module

import android.arch.lifecycle.ViewModel
import com.funtsui.dell.kotlindarggermvvm.vm.AppViewModel
import com.funtsui.dell.kotlindarggermvvm.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * 全局的ViewModel提供模块
 *
 */
@Module
internal abstract class AppViewModelModule {


    //避免因没有Provider<ViewModel>造成ViewModelFactory无法生成，编译无法通过,需要有最少一个ViewModel提供到Map中
    //AppViewModel这里做占坑用,全局的ViewModel最好按业务划分，继承于AppViewModel
    @Binds
    @IntoMap
    @ViewModelKey(AppViewModel::class)
    abstract fun bindAppViewModel(vm: AppViewModel): ViewModel

}