package com.funtsui.dell.kotlindarggermvvm.defaul

import android.arch.lifecycle.Observer
import android.support.v4.app.FragmentActivity
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.event.ProgressLiveData
import com.funtsui.dell.kotlindarggermvvm.eventshow.ProgressDialog

class DefaultProgressObserver(val owner: FragmentActivity) : Observer<ProgressLiveData.Progress> {
    companion object {
        const val PROGRESS_TAG = -100
    }
    private val progressDialog by lazy { getProgress() }


    override fun onChanged(it: ProgressLiveData.Progress?) {
        val show = it?.show ?: false
        if (show) {
//            progressDialog.setMessage(it?.message)
            progressDialog.show()
            progressDialog.setCancelable(it?.cancelable ?:false)
        } else if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    /**
     * 获取Activity内唯一的ProgressDialog,避免多个VM对象操作造成多个Progress同时显示问题
     */
    private fun getProgress(): ProgressDialog {
        val root = owner.findViewById<View>(android.R.id.content)
        val progress = root.getTag(PROGRESS_TAG)
        if (progress != null) {
            return progress as ProgressDialog
        }
        val dialog = ProgressDialog(owner)
        root.setTag(PROGRESS_TAG, dialog)
        return dialog
    }
}