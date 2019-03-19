package com.funtsui.dell.kotlindarggermvvm.di.main

import com.funtsui.dell.kotlindarggermvvm.di.scope.FragmentScope
import com.funtsui.dell.kotlindarggermvvm.ui.FreeFragment
import com.funtsui.dell.kotlindarggermvvm.ui.HistoryFragment
import com.funtsui.dell.kotlindarggermvvm.ui.PlayFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ZhgMainFragmentBindModule {

  //免费计划

    @FragmentScope
    @ContributesAndroidInjector(modules = [FreeViewModelModule::class])
    abstract fun freeFragmentInjector(): FreeFragment

   // 历史记录

    @FragmentScope
    @ContributesAndroidInjector(modules = [HistroyViewModelModule::class])
    abstract fun historyFragmentInjector(): HistoryFragment

   // 玩法走势

    @FragmentScope
    @ContributesAndroidInjector(modules = [PlayViewModelModule::class])
    abstract fun playFragmentInjector(): PlayFragment


}