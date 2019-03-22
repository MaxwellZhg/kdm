package com.funtsui.dell.kotlindarggermvvm.download

import okhttp3.Interceptor
import okhttp3.Response
import java.util.HashMap

/**
 * Created by zhg on 2019/3/21.
 */
class DownloadInterceptor(
    private val update: (String, Long, Long, Boolean) -> Unit
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalResponse = chain.proceed(request)
        return originalResponse.newBuilder()
            .body(DownloadResponseBody(request.url().toString(), originalResponse.body()!!, update))
            .build()
    }

}