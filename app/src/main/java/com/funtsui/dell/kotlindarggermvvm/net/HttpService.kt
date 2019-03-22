package com.funtsui.dell.kotlindarggermvvm.net

import com.funtsui.dell.kotlindarggermvvm.BuildConfig
import com.funtsui.dell.kotlindarggermvvm.download.DownloadClient

/**
 * Created by zhg on 2019/3/18.
 */
object HttpService{
    val officialApi: IJeckApi by lazy {
        RetorifitClient.Builder(IJeckApi::class.java, BuildConfig.LOG_DEBUG,
            IPublishConstantPool.sCommonUrl,
            headers = {
                val hashMap = HashMap<String, String>()
                // 头部
                hashMap
            },
            readTimeout = 15,
            connectionTimeout = 15).create()
    }

    /**
     * 下载工具类
     */
    val downloadApi by lazy {
        DownloadClient.Builder(AppCache.application, true, "").create()
    }
}