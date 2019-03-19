package com.funtsui.dell.kotlindarggermvvm.di.main

import android.arch.lifecycle.ViewModel
import com.funtsui.dell.kotlindarggermvvm.di.ViewModelKey
import com.funtsui.dell.kotlindarggermvvm.vm.FreeViewModel
import com.funtsui.dell.testmavenlib.vm.TestMavenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by zhg on 2019/1/10.
 */

@Module
internal abstract class FreeViewModelModule {

    // 将View添加到Map
    @Binds
    @IntoMap
    @ViewModelKey(FreeViewModel::class)
    abstract fun bindFreeViewModel(vm: FreeViewModel): ViewModel

}