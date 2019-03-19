package com.funtsui.dell.kotlindarggermvvm.event

import com.funtsui.dell.kotlindarggermvvm.enum.IToast

class ToastLiveData : EventLiveData<ToastLiveData.Toast>() {

    fun show(message: String, type: IToast = IToast.NORMAL) {
        postEvent(Toast(type, message))
    }

    class Toast(val type: IToast, val message: String)
}