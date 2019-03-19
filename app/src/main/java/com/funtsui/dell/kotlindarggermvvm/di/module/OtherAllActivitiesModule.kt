package com.funtsui.dell.kotlindarggermvvm.di.module

import com.funtsui.dell.kotlindarggermvvm.TestMavenActivity
import com.funtsui.dell.kotlindarggermvvm.di.main.PublishTestViewModule
import com.funtsui.dell.kotlindarggermvvm.di.main.PublishViewModule
import com.funtsui.dell.kotlindarggermvvm.di.main.TestMavenViewModelModule
import com.funtsui.dell.kotlindarggermvvm.di.main.ZhgMainFragmentBindModule
import com.funtsui.dell.kotlindarggermvvm.di.scope.ActivityScope
import com.ssf.tc.publish.PublishMainActivity
import com.ssf.tc.publish.PublishTestActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @atuthor ydm
 * @data on 2018/8/13
 * @describe
 */
@Module
internal abstract class OtherAllActivitiesModule {

   //todo 问题引用
    @ActivityScope
    @ContributesAndroidInjector(modules = [TestMavenViewModelModule::class,ZhgMainFragmentBindModule::class])
    abstract fun contributeTestMavenActivityInjector(): TestMavenActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PublishViewModule::class])
    abstract fun contributePublishMainActivityInjector(): PublishMainActivity

   @ActivityScope
   @ContributesAndroidInjector(modules = [PublishTestViewModule::class])
   abstract fun contributePublishTestActivityInjector(): PublishTestActivity

}