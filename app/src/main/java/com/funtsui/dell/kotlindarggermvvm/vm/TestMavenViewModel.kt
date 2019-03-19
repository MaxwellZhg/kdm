package com.funtsui.dell.testmavenlib.vm


import android.app.Application
import android.databinding.ObservableField
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.base.BaseViewModel
import javax.inject.Inject

open class TestMavenViewModel @Inject constructor(app: Application): BaseViewModel(app){
  var test = ObservableField<String>()
    init {
        test.set("测试数据")
    }

    fun detail (view:View){
        test.set("11111111")
    }
}
