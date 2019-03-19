package com.funtsui.dell.kotlindarggermvvm.di.main

import android.arch.lifecycle.ViewModel
import com.funtsui.dell.testmavenlib.vm.TestMavenViewModel
import com.funtsui.dell.kotlindarggermvvm.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class TestMavenViewModelModule {

    // 将View添加到Map
    @Binds
    @IntoMap
    @ViewModelKey(TestMavenViewModel::class)
    abstract fun bindTestMavenViewModel(vm: TestMavenViewModel): ViewModel

}
