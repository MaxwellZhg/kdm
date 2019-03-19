package com.funtsui.dell.kotlindarggermvvm.vm

import android.app.Application
import android.databinding.ObservableField
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by zhg on 2019/1/10.
 */
class HistroyViewModel @Inject constructor(app:Application):BaseViewModel(app){
    var test = ObservableField<String>()
    init {
        test.set("测试数据his")
    }

    fun detail (view: View){
        test.set("11111111")
    }
}