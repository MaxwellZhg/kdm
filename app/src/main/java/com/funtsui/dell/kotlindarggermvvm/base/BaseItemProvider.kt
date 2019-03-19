package com.funtsui.dell.kotlindarggermvvm.base

import android.view.View


/**
 * 基本Item布局处理提供者
 * Created by Hzz on 2018/9/28
 */
abstract class BaseItemProvider<T, BindingHolder : BaseBindingViewHolder<*>> {
    abstract fun layout(): Int
    abstract fun convert(holder: BindingHolder, data: T, position: Int)

    open fun onClick(view: View, data: T, position: Int) {

    }

    open fun onLongClick(view: View, data: T, position: Int) {

    }
}