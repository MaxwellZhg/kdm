package com.funtsui.dell.kotlindarggermvvm.net

import okhttp3.Interceptor
import okhttp3.Response
import java.util.HashMap

/**
 * Created by zhg on 2019/3/18.
 */
class HeaderInterceptor(private val headers: () -> HashMap<String, String>) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        headers().entries.forEach {
            if (it.value.isNotEmpty()) {
                builder.addHeader(it.key, it.value)
            }
        }
        return chain.proceed(builder.url(request.url()).build())
    }

}