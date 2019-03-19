package com.funtsui.dell.kotlindarggermvvm.di.module


import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @atuthor ydm
 * @data on 2018/8/13
 * @describe
 */
@Module
internal object OtherAppModule {


   /* @Singleton
    @Provides
    @JvmStatic
    fun providePublishApi(application: Application): IPublishApi {
        return RetrofitClient.Builder(IPublishApi::class.java, BuildConfig.LOG_DEBUG,
                IPublishConstantPool.sCommonUrl,
                headers = {
                    val hashMap = HashMap<String, String>()
                    // 头部
                    hashMap
                },
                readTimeout = 6,
                connectionTimeout = 6).create()
    }*/


}