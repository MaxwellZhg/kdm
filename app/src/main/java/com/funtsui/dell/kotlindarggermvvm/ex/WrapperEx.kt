package com.funtsui.dell.kotlindarggermvvm.ex

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.funtsui.dell.kotlindarggermvvm.enum.IToast
import com.funtsui.dell.kotlindarggermvvm.eventshow.HintDialog
import com.funtsui.dell.kotlindarggermvvm.eventshow.ProgressDialog
import com.funtsui.dell.kotlindarggermvvm.inter.IConfig
import es.dmoral.toasty.Toasty


/**
 * 自定义Dialog区域
 */
public inline fun AppCompatActivity.createHintDialog(message: String, title: String = "提示", sureText: String = "确定", cancelText: String?  = "取消"): HintDialog {
    return HintDialog.newInstance(message, title, sureText, cancelText)
}
/**
 * 自定义Dialog区域
 */
public inline fun AppCompatActivity.showHintDialog(message: String, title: String = "提示", sureText: String = "确定", cancelText: String?  = "取消", noinline sureListener: (View) -> Unit, noinline dismissListener: (View) -> Unit = {}): HintDialog {
    return HintDialog.newInstance(message, title, sureText, cancelText).show(this.supportFragmentManager, IConfig.HintDialog_TAG, sureListener, dismissListener)
}

public inline fun Fragment.showHintDialog(message: String, title: String = "提示", sureText: String = "确定", cancelText: String? = "取消", noinline sureListener: (View) -> Unit, noinline dismissListener: (View) -> Unit = {}): HintDialog {
    return HintDialog.newInstance(message, title, sureText, cancelText).show(this.fragmentManager!!, IConfig.HintDialog_TAG, sureListener, dismissListener)
}


/**
 * 显示加载进度条
 */
public inline fun AppCompatActivity.showProgressDialog(isCancelable: Boolean = false, noinline dismissCallback: () -> Unit = {}): ProgressDialog {
    val dialog = ProgressDialog(this)
    dialog.setDismissCallback(dismissCallback)
    dialog.setCancelable(isCancelable)
    dialog.show()
    return dialog
}

public inline fun Fragment.showProgressDialog(isCancelable: Boolean = false, noinline dismissCallback: () -> Unit = {}): ProgressDialog {
    val dialog = ProgressDialog(context!!)
    dialog.setCancelable(isCancelable)
    dialog.show()
    return dialog
}


/**
 * Toast
 */
public inline fun Context.toast(message: String, type: IToast = IToast.NORMAL, duration: Int = 0, icon: Drawable? = null, withIcon: Boolean = false) {
    when (type) {
        IToast.NORMAL -> Toasty.normal(this, message, duration, icon, withIcon).show()
        IToast.INFO -> Toasty.info(this, message, duration, withIcon).show()
        IToast.SUCCESS -> Toasty.success(this, message, duration, withIcon).show()
        IToast.WARING -> Toasty.warning(this, message, duration, withIcon).show()
        IToast.ERROR -> Toasty.error(this, message, duration).show()
        else -> {
            Toast.makeText(this,message,duration).show()
        }
    }
}

/**
 * Toast
 */
public inline fun Context.toast(@StringRes messageRes: Int, type: IToast = IToast.NORMAL, duration: Int = 0, icon: Drawable? = null, withIcon: Boolean = false) {
    val message = getString(messageRes)
    when (type) {
        IToast.NORMAL -> Toasty.normal(this, message, duration, icon, withIcon).show()
        IToast.INFO -> Toasty.info(this, message, duration, withIcon).show()
        IToast.SUCCESS -> Toasty.success(this, message, duration, withIcon).show()
        IToast.WARING -> Toasty.warning(this, message, duration, withIcon).show()
        IToast.ERROR -> Toasty.error(this, message, duration).show()
        else -> {
            Toast.makeText(this,message,duration).show()
        }
    }
}