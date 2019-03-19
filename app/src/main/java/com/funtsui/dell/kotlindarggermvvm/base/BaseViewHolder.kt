package com.funtsui.dell.kotlindarggermvvm.base

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.autolayout.utils.AutoUtils

class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val views = SparseArray<View>()

    init {
        AutoUtils.autoSize(itemView)
    }

    operator fun <T : View> get(viewId: Int): T {
        var view: View? = views.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            views.put(viewId, view)
        }
        return view as T
    }

}