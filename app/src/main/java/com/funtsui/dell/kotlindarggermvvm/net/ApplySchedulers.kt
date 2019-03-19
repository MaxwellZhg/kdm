package com.funtsui.dell.kotlindarggermvvm.net

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by zhg on 2019/3/18.
 */
class ApplySchedulers<T>(private val retry:Boolean = true):ObservableTransformer<T,T>{
    override fun apply(upstream: Observable<T>): ObservableSource<T> = if(retry){
        upstream
            // .delay(5, TimeUnit.SECONDS)     //请求延迟五秒，再开始
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread(), true)
            .retryWhen(RetryWhenNetwork())
    }else{
        upstream
            // .delay(5, TimeUnit.SECONDS)     //请求延迟五秒，再开始
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread(), true)
    }

}