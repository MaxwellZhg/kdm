package com.funtsui.dell.kotlindarggermvvm.defaul

import android.arch.lifecycle.Observer
import android.support.v4.app.FragmentActivity
import com.funtsui.dell.kotlindarggermvvm.enum.IToast
import com.funtsui.dell.kotlindarggermvvm.event.ErroeLiveData
import com.funtsui.dell.kotlindarggermvvm.ex.toast

class DefaultErrorObserver(val owner: FragmentActivity) : Observer<ErroeLiveData.Error> {
    override fun onChanged(it: ErroeLiveData.Error?) {
        owner.toast(it?.message ?: "", IToast.NORMAL)
    }
}