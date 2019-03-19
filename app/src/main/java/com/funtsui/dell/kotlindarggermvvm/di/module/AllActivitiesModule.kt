package com.funtsui.dell.kotlindarggermvvm.di.module
import android.arch.lifecycle.ViewModelProvider
import com.funtsui.dell.kotlindarggermvvm.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class AllActivitiesModule {



    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}