package com.funtsui.dell.kotlindarggermvvm.net

import com.socks.library.KLog
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.rxkotlin.zipWith
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.sql.Wrapper
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * Created by zhg on 2019/3/18.
 */
class RetryWhenNetwork:Function<Observable<Throwable>,Observable<*>>{
    //    retry次数
    private val count = 3
    //    延迟多少秒后重试
    private val delay: Long = 3000
    //    叠加延迟
    private val increaseDelay: Long = 3000

    @Throws(Exception::class)
    override fun apply(observable:Observable<Throwable>): Observable<*> {
      return observable.zipWith(
          Observable.range(1,count+1),
          BiFunction<Throwable,Int,Wrapper>{
              t1, t2 ->  Wrapper(t1,t2)
          }
      ).flatMap {
          if ((it.throwable is ConnectException
                      || it.throwable is SocketTimeoutException
                      || it.throwable is TimeoutException) && it.index < count + 1){
              // 重试链接
              KLog.i("异常：${it.throwable.localizedMessage} 重试中，次数(${it.index})")
              Observable.timer(delay + (it.index - 1) * increaseDelay, TimeUnit.MILLISECONDS)
          }else{
              Observable.error<Wrapper>(it.throwable)
          }
      }
    }

    private inner class Wrapper(val throwable: Throwable, val index: Int)

}