package com.funtsui.dell.kotlindarggermvvm.net

import com.funtsui.dell.kotlindarggermvvm.bean.TestBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by zhg on 2019/3/18.
 */
interface IJeckApi{
    @GET(IPublishConstantPool.sTest)
    fun checkLotteryList(
    ): Observable<Response<TestBean>>
}

