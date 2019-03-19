package com.funtsui.dell.kotlindarggermvvm.di.main

import android.arch.lifecycle.ViewModel
import com.funtsui.dell.kotlindarggermvvm.di.ViewModelKey
import com.funtsui.dell.kotlindarggermvvm.vm.HistroyViewModel
import com.funtsui.dell.testmavenlib.vm.TestMavenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by zhg on 2019/1/10.
 */

@Module
internal abstract class HistroyViewModelModule {

    // 将View添加到Map
    @Binds
    @IntoMap
    @ViewModelKey(HistroyViewModel::class)
    abstract fun bindHistroyViewModel(vm: HistroyViewModel): ViewModel

}