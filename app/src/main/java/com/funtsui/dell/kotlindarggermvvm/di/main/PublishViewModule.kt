package com.funtsui.dell.kotlindarggermvvm.di.main

import android.arch.lifecycle.ViewModel
import com.funtsui.dell.kotlindarggermvvm.di.ViewModelKey
import com.funtsui.dell.testmavenlib.vm.TestMavenViewModel
import com.ssf.tc.publish.vm.PublishViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by zhg on 2019/1/21.
 */

@Module
internal abstract class PublishViewModule {

    // 将View添加到Map
    @Binds
    @IntoMap
    @ViewModelKey(PublishViewModel::class)
    abstract fun bindPublishViewModel(vm: PublishViewModel): ViewModel

}