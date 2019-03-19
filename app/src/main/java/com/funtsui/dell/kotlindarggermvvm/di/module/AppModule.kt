package com.funtsui.dell.kotlindarggermvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @atuthor ydm
 * @data on 2018/8/13
 * @describe
 */
@Module
internal object AppModule {


    @Singleton
    @Provides
    @JvmStatic
    /**
     * 共享的ViewModelProvider，提供全局的ViewModelStore
     * @param factory factory的创建需要有Map<Class,ViewModel>的支持，所以需要IntoMap来提供具体的ViewModel
     * @see AppViewModelModule
     */
    fun getShareViewModelProvider(factory: ViewModelProvider.Factory): ViewModelProvider {
        val viewModelStore = ViewModelStore()
        return ViewModelProvider(viewModelStore, factory)
    }

}