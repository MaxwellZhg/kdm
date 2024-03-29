package com.funtsui.dell.kotlindarggermvvm.net

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.funtsui.dell.kotlindarggermvvm.eventshow.HintDialog
import com.socks.library.KLog
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxDialogFragment
import com.trello.rxlifecycle2.components.support.RxFragment
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import retrofit2.Response
import java.util.ArrayList

/**
 * Created by zhg on 2019/3/18.
 */
/**
 * activity网络请求扩展
 */
/**
 * activity网络请求扩展
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T> Observable<T>.apply(
    // 必传对象，用于控制声明周期
    rx: RxAppCompatActivity,
    // dialog呈现方式，三种：UN_LOADING(不显示),NORMAL_LOADING(显示可关闭),NORMAL_LOADING(显示可关闭),FORBID_LOADING(显示不关闭)
    iDialog: IDialog = IDialog.FORBID_LOADING,
    // 成功回调
    noinline success: (T) -> Unit,
    // 失败回调
    noinline error: (Throwable) -> Unit = {},
    // 成功后，并执行完 success 方法后回调
    noinline complete: () -> Unit = {},
    // 网络失败，是否重试请求
    retry: Boolean = true
) {
    this.compose(ApplySchedulers(retry))
        .compose(rx.bindUntilEvent(ActivityEvent.DESTROY))
        .subscribe(ProgressSubscriber(rx, iDialog = iDialog, responseListener = object : ResponseListener<T> {

            override fun onSucceed(data: T) {
                try {
                    success(data)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onError(exception: Throwable) {
                try {
                    error(exception)
                } catch (e: Exception) {
                    e.printStackTrace()
                    KLog.e("onError函数调用奔溃")
                }
            }

            override fun onComplete() {
                complete()
            }
        }))
}

/**
 * activity网络请求扩展
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T> Observable<Response<T>>.convert(
    // 必传对象，用于控制声明周期
    rx: RxAppCompatActivity,
    // dialog呈现方式，三种：UN_LOADING(不显示),NORMAL_LOADING(显示可关闭),NORMAL_LOADING(显示可关闭),FORBID_LOADING(显示不关闭)
    iDialog: IDialog = IDialog.FORBID_LOADING,
    // 成功回调
    noinline success: (T) -> Unit,
    // 失败回调
    noinline error: (Throwable) -> Unit = {},
    // 成功后，并执行完 success 方法后回调
    noinline complete: () -> Unit = {},
    // 网络失败，是否重试请求
    retry: Boolean = true
) {
    this.compose(ConvertSchedulers(retry))
        .compose(rx.bindUntilEvent(ActivityEvent.DESTROY))
        .subscribe(ProgressSubscriber(rx, iDialog = iDialog, responseListener = object :
            ResponseListener<T> {

            override fun onSucceed(data: T) {
                try {
                    success(data)
                } catch (e: Exception) {
                    e.printStackTrace()
                    onError(e)
                }
            }

            override fun onError(exception: Throwable) {
                try {
                    error(exception)
                } catch (e: Exception) {
                    e.printStackTrace()
                    KLog.e("onError函数调用奔溃")
                }
            }

            override fun onComplete() {
                complete()
            }
        }))
}


/**
 * fragment网络请求扩展
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T> Observable<T>.apply(
    // 必传对象，用于控制声明周期
    rx: RxFragment,
    // dialog呈现方式，三种：UN_LOADING(不显示),NORMAL_LOADING(显示可关闭),NORMAL_LOADING(显示可关闭),FORBID_LOADING(显示不关闭)
    iDialog: IDialog = IDialog.FORBID_LOADING,
    // 成功回调
    noinline success: (T) -> Unit,
    // 失败回调
    noinline error: (Throwable) -> Unit = {},
    // 成功后，并执行完 success 方法后回调
    noinline complete: () -> Unit = {},
    // 网络失败，是否重试请求
    retry: Boolean = true
) {
    this.compose(ApplySchedulers(retry))
        .compose(rx.bindUntilEvent(FragmentEvent.DESTROY))
        .subscribe(ProgressSubscriber(rx.activity!!, iDialog = iDialog, responseListener = object : ResponseListener<T> {

            override fun onSucceed(data: T) {
                try {
                    success(data)
                } catch (e: Exception) {
                    e.printStackTrace()
                    onError(e)
                }
            }

            override fun onError(exception: Throwable) {
                try {
                    error(exception)
                } catch (e: Exception) {
                    e.printStackTrace()
                    KLog.e("onError函数调用奔溃")
                }
            }

            override fun onComplete() {
                complete()
            }
        }))
}

@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T> Observable<Response<T>>.convert(
    // 必传对象，用于控制声明周期
    rx: RxFragment,
    // dialog呈现方式，三种：UN_LOADING(不显示),NORMAL_LOADING(显示可关闭),NORMAL_LOADING(显示可关闭),FORBID_LOADING(显示不关闭)
    iDialog: IDialog = IDialog.FORBID_LOADING,
    // 成功回调
    noinline success: (T) -> Unit,
    // 失败回调
    noinline error: (Throwable) -> Unit = {},
    // 成功后，并执行完 success 方法后回调
    noinline complete: () -> Unit = {},
    // 网络失败，是否重试请求
    retry: Boolean = true
) {
    this.compose(ConvertSchedulers(retry))
        .compose(rx.bindUntilEvent(FragmentEvent.DESTROY))
        .subscribe(ProgressSubscriber(rx.activity!!, iDialog = iDialog, responseListener = object : ResponseListener<T> {

            override fun onSucceed(data: T) {
                try {
                    success(data)
                } catch (e: Exception) {
                    e.printStackTrace()
                    onError(e)
                }
            }

            override fun onError(exception: Throwable) {
                try {
                    error(exception)
                } catch (e: Exception) {
                    e.printStackTrace()
                    KLog.e("onError函数调用奔溃")
                }
            }

            override fun onComplete() {
                complete()
            }
        }))
}

/**
 * DialogFragment网络请求扩展
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T> Observable<T>.apply(
    // 必传对象，用于控制声明周期
    rx: RxDialogFragment,
    // dialog呈现方式，三种：UN_LOADING(不显示),NORMAL_LOADING(显示可关闭),NORMAL_LOADING(显示可关闭),FORBID_LOADING(显示不关闭)
    iDialog: IDialog = IDialog.FORBID_LOADING,
    // 成功回调
    noinline success: (T) -> Unit,
    // 失败回调
    noinline error: (Throwable) -> Unit = {},
    // 成功后，并执行完 success 方法后回调
    noinline complete: () -> Unit = {},
    // 网络失败，是否重试请求
    retry: Boolean = true
) {
    this.compose(ApplySchedulers(retry))
        .compose(rx.bindUntilEvent(FragmentEvent.DESTROY_VIEW))
        .subscribe(ProgressSubscriber(rx.activity!!, iDialog = iDialog, responseListener = object : ResponseListener<T> {

            override fun onSucceed(data: T) {
                try {
                    success(data)
                } catch (e: Exception) {
                    e.printStackTrace()
                    onError(e)
                }
            }

            override fun onError(exception: Throwable) {
                try {
                    error(exception)
                } catch (e: Exception) {
                    e.printStackTrace()
                    KLog.e("onError函数调用奔溃")
                }
            }

            override fun onComplete() {
                complete()
            }
        }))
}

/**
 * DialogFragment网络请求扩展
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T> Observable<Response<T>>.convert(
    // 必传对象，用于控制声明周期
    rx: RxDialogFragment,
    // dialog呈现方式，三种：UN_LOADING(不显示),NORMAL_LOADING(显示可关闭),NORMAL_LOADING(显示可关闭),FORBID_LOADING(显示不关闭)
    iDialog: IDialog = IDialog.FORBID_LOADING,
    // 成功回调
    noinline success: (T) -> Unit,
    // 失败回调
    noinline error: (Throwable) -> Unit = {},
    // 成功后，并执行完 success 方法后回调
    noinline complete: () -> Unit = {},
    // 网络失败，是否重试请求
    retry: Boolean = true
) {
    this.compose(ConvertSchedulers(retry))
        .compose(rx.bindUntilEvent(FragmentEvent.DESTROY_VIEW))
        .subscribe(ProgressSubscriber(rx.activity!!, iDialog = iDialog, responseListener = object : ResponseListener<T> {

            override fun onSucceed(data: T) {
                try {
                    success(data)
                } catch (e: Exception) {
                    e.printStackTrace()
                    onError(e)
                }
            }

            override fun onError(exception: Throwable) {
                try {
                    error(exception)
                } catch (e: Exception) {
                    e.printStackTrace()
                    KLog.e("onError函数调用奔溃")
                }
            }

            override fun onComplete() {
                complete()
            }
        }))
}


/**
 * Activity扩展，加入生命周期控制，并没有重试操作
 * @param rx life
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T> Observable<T>.wrapper(rx: RxAppCompatActivity): Observable<T> {
    return this.compose(wrapperSchedulers())
        .compose(rx.bindUntilEvent(ActivityEvent.DESTROY))
}

/**
 * Fragment扩展，加入生命周期控制，并没有重试操作
 * @param rx life
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T> Observable<T>.wrapper(rx: RxFragment): Observable<T> {
    return this.compose(wrapperSchedulers())
        .compose(rx.bindUntilEvent(FragmentEvent.DESTROY))
}


/**
 * Activity扩展，加入生命周期控制，有重试操作
 * @param rx life
 */
public inline fun <T> Observable<Response<T>>.convertRequest(rx: RxAppCompatActivity, retry: Boolean = true): Observable<T> {
    return this.compose(ConvertSchedulers(retry))
        .compose(rx.bindUntilEvent(ActivityEvent.DESTROY))
}


/**
 * DialogFragment扩展，加入生命周期控制，并没有重试操作
 * @param rx life
 */
public inline fun <T> Observable<T>.wrapper(rx: RxDialogFragment): Observable<T> {
    return this.compose(wrapperSchedulers())
        .compose(rx.bindUntilEvent(FragmentEvent.DESTROY_VIEW))
}


/**
 * Fragment扩展，加入生命周期控制，有重试操作
 * @param rx life
 */
public inline fun <T> Observable<Response<T>>.convertRequest(rx: RxFragment, retry: Boolean = true): Observable<T> {
    return this.compose(ConvertSchedulers(retry))
        .compose(rx.bindUntilEvent(FragmentEvent.DESTROY))
}



/**
 * DialogFragment扩展，加入生命周期控制，并没有重试操作
 * @param rx life
 */
public inline fun <T> Observable<Response<T>>.convertRequest(rx: RxDialogFragment, retry: Boolean = true): Observable<T> {
    return this.compose(ConvertSchedulers(retry))
        .compose(rx.bindUntilEvent(FragmentEvent.DESTROY_VIEW))
}


/**
 * 组合 zip操作符号
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T1, T2> RxFragment.convertZip(
    t1: Observable<Response<T1>>,
    t2: Observable<Response<T2>>,
    // dialog呈现方式，三种：UN_LOADING(不显示),NORMAL_LOADING(显示可关闭),NORMAL_LOADING(显示可关闭),FORBID_LOADING(显示不关闭)
    iDialog: IDialog = IDialog.FORBID_LOADING,
    // 成功回调
    crossinline success: (T1, T2) -> Unit,
    // 失败回调
    noinline error: (Throwable) -> Unit = {},
    // 成功后，并执行完 success 方法后回调
    noinline complete: () -> Unit = {},
    retry: Boolean = true
) {

    Observable.zip(t1.convertRequest(this, retry), t2.convertRequest(this, retry), BiFunction<T1, T2, ArrayList<Any>> { t1, t2 ->
        val arrayList = ArrayList<Any>()
        arrayList.add(t1 as Any)
        arrayList.add(t2 as Any)
        arrayList
    }).subscribe(ProgressSubscriber(activity!!, iDialog, responseListener = object : ResponseListener<ArrayList<Any>> {
        override fun onSucceed(data: ArrayList<Any>) {
            try {
                success(data[0] as T1, data[1] as T2)
            } catch (e: Exception) {
                e.printStackTrace()
                onError(e)
            }
        }

        override fun onError(exception: Throwable) {
            try {
                error(exception)
            } catch (e: Exception) {
                e.printStackTrace()
                KLog.e("onError函数调用奔溃")
            }
        }

        override fun onComplete() {
            complete()
        }
    }))
}

/**
 * 组合 zip操作符号
 */
@Deprecated(message = "This method is no longer supported, do not use it.")
public inline fun <T1, T2> RxAppCompatActivity.convertZip(
    t1: Observable<Response<T1>>,
    t2: Observable<Response<T2>>,
    // dialog呈现方式，三种：UN_LOADING(不显示),NORMAL_LOADING(显示可关闭),NORMAL_LOADING(显示可关闭),FORBID_LOADING(显示不关闭)
    iDialog: IDialog = IDialog.FORBID_LOADING,
    // 成功回调
    crossinline success: (T1, T2) -> Unit,
    // 失败回调
    noinline error: (Throwable) -> Unit = {},
    // 成功后，并执行完 success 方法后回调
    noinline complete: () -> Unit = {},
    retry: Boolean = true
) {

    Observable.zip(t1.convertRequest(this, retry), t2.convertRequest(this, retry), BiFunction<T1, T2, ArrayList<Any>> { t1, t2 ->
        val arrayList = ArrayList<Any>()
        arrayList.add(t1 as Any)
        arrayList.add(t2 as Any)
        arrayList
    }).subscribe(ProgressSubscriber(this, iDialog, responseListener = object : ResponseListener<ArrayList<Any>> {
        override fun onSucceed(data: ArrayList<Any>) {
            try {
                success(data[0] as T1, data[1] as T2)
            } catch (e: Exception) {
                e.printStackTrace()
                onError(e)
            }
        }

        override fun onError(exception: Throwable) {
            error(exception)
        }

        override fun onComplete() {
            complete()
        }
    }))
}

/**
 * 当前网络状态是否在线
 */
fun Context.isNetworkAvailable(): Boolean {
    try {
        val connectivity = getSystemService(Context.CONNECTIVITY_SERVICE)
        if (connectivity != null) {
            connectivity as ConnectivityManager
            val info = connectivity.activeNetworkInfo
            if (info != null && info.isConnected) {
                if (info.state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
    return false
}