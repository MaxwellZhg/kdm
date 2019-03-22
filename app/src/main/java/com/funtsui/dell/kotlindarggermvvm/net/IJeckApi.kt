package com.funtsui.dell.kotlindarggermvvm.net

import com.funtsui.dell.kotlindarggermvvm.bean.ShelvesInfoBean
import com.funtsui.dell.kotlindarggermvvm.bean.TestBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by zhg on 2019/3/18.
 */
interface IJeckApi{
    @GET(IPublishConstantPool.sTest)
    fun checkLotteryList(
    ): Observable<Response<TestBean>>
    @GET
    fun getShelvesInfo(@Url url: String): Observable<Response<ShelvesInfoBean>>
}

