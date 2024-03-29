package com.funtsui.dell.kotlindarggermvvm.net

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

/**
 * Created by zhg on 2019/3/18.
 */
class ConvertSchedulers<T>(private val retry: Boolean = true) : ObservableTransformer<Response<T>, T> {
    override fun apply(upstream: Observable<Response<T>>): ObservableSource<T> =
        if (retry) {
            upstream
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .flatMap { response ->
                    if (response.isSuccessful) {
                        Observable.just(response.body()!!)
                    } else {
                        val code = response.code()
                        val string = response.errorBody()!!.string()
                        Observable.error(ApiException(CodeException.NotSuccessfulException, code, string))
                    }
                }.observeOn(AndroidSchedulers.mainThread(), true)
                .retryWhen(RetryWhenNetwork())
        } else {
            upstream
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .flatMap { response ->
                    if (response.isSuccessful) {
                        Observable.just(response.body()!!)
                    } else {
                        val code = response.code()
                        val string = response.errorBody()!!.string()
                        Observable.error(ApiException(CodeException.NotSuccessfulException, code, string))
                    }
                }.observeOn(AndroidSchedulers.mainThread(), true)
        }

}