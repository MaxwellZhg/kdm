package com.funtsui.dell.kotlindarggermvvm.defaul

import android.arch.lifecycle.Observer
import android.support.v4.app.FragmentActivity
import com.funtsui.dell.kotlindarggermvvm.enum.IToast
import com.funtsui.dell.kotlindarggermvvm.event.ToastLiveData
import com.funtsui.dell.kotlindarggermvvm.ex.toast

class DefaultToastObserver(val owner: FragmentActivity) : Observer<ToastLiveData.Toast> {

    override fun onChanged(it: ToastLiveData.Toast?) {
        owner.toast(it?.message ?: "", it?.type ?: IToast.NORMAL)
    }

}