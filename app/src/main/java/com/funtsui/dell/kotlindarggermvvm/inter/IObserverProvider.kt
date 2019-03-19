package com.funtsui.dell.kotlindarggermvvm.inter

import android.arch.lifecycle.Observer
import android.support.v4.app.FragmentActivity
import com.funtsui.dell.kotlindarggermvvm.event.ErroeLiveData
import com.funtsui.dell.kotlindarggermvvm.event.ProgressLiveData
import com.funtsui.dell.kotlindarggermvvm.event.ToastLiveData

interface IObserverProvider{
    fun providerProgressObserver(owner: FragmentActivity): Observer<ProgressLiveData.Progress>?
    fun providerToastObserver(owner: FragmentActivity): Observer<ToastLiveData.Toast>?
    fun providerErrorObserver(owner: FragmentActivity): Observer<ErroeLiveData.Error>?
}