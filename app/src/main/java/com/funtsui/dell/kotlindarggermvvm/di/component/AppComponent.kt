package com.funtsui.dell.kotlindarggermvvm.di.component

import android.app.Application
import com.funtsui.dell.kotlindarggermvvm.TestMavenApp
import com.funtsui.dell.kotlindarggermvvm.di.module.OtherAllActivitiesModule
import com.funtsui.dell.kotlindarggermvvm.di.module.OtherAppModule
import com.funtsui.dell.kotlindarggermvvm.di.module.OtherAppViewModelModule
import com.funtsui.dell.kotlindarggermvvm.di.module.AllActivitiesModule
import com.funtsui.dell.kotlindarggermvvm.di.module.AppModule
import com.funtsui.dell.kotlindarggermvvm.di.module.AppViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @atuthor ydm
 * @data on 2018/8/13
 * @describe
 */
@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            AndroidSupportInjectionModule::class,
            // 全局提供的module
            AppModule::class,
            AppViewModelModule::class,
            AllActivitiesModule::class,
            // 差异模块
            OtherAppModule::class,
            OtherAppViewModelModule::class,
            OtherAllActivitiesModule::class
        ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: TestMavenApp)
}