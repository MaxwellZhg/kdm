package com.funtsui.dell.kotlindarggermvvm.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.funtsui.dell.kotlindarggermvvm.event.ActivityLiveData
import com.funtsui.dell.kotlindarggermvvm.event.ErroeLiveData
import com.funtsui.dell.kotlindarggermvvm.event.ProgressLiveData
import com.funtsui.dell.kotlindarggermvvm.event.ToastLiveData
import com.funtsui.dell.kotlindarggermvvm.inter.ViewModelEvent
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

open class BaseViewModel @Inject constructor(app:Application):AndroidViewModel(app),LifecycleProvider<ViewModelEvent>{
    private val lifecycleSubject = BehaviorSubject.create<ViewModelEvent>()
    val progress = ProgressLiveData()
    val error = ErroeLiveData()
    val toast = ToastLiveData()
    val activity = ActivityLiveData()

    override fun onCleared() {
        super.onCleared()
        lifecycleSubject.onNext(ViewModelEvent.CLEAR)
    }
    override fun lifecycle(): Observable<ViewModelEvent> {
        return lifecycle().hide()
    }

    override fun <T : Any?> bindUntilEvent(event: ViewModelEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event)
    }

    override fun <T : Any?> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycleViewModel.bindViewModel(lifecycleSubject)
    }


}