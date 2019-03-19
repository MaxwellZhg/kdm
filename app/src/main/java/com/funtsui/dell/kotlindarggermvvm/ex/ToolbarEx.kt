package com.funtsui.dell.kotlindarggermvvm.ex

import android.support.annotation.DrawableRes
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.funtsui.dell.kotlindarggermvvm.R
import com.funtsui.dell.kotlindarggermvvm.base.BaseFragment
import com.ssf.tc.publish.ex.rotate
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxFragment


/**
 * Fragment使用
 *
 * @param title         标题
 * @param rightRes      右侧图标
 * @param rightCallBack 右侧点击回调
 * @param isShowDrop    是否显示标题旁边的下拉标签，用于动画
 */
public inline fun BaseFragment.setToolbarTitle(
        title: String,
        @DrawableRes rightRes: Int = 0,
        rightCallBack: View.OnClickListener? = null,
        isShowDrop: Boolean = false
) {
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    toolbar.findViewById<TextView>(R.id.tv_actionbar_title).text = title
    // 是否有右侧图标
    if (rightRes != 0) {
        toolbar.findViewById<View>(R.id.ll_right_bar).visibility = View.VISIBLE
        toolbar.findViewById<ImageView>(R.id.iv_right_image).setImageResource(rightRes)
        //监听
        if (rightCallBack != null) {
            toolbar.findViewById<View>(R.id.ll_right_bar).setOnClickListener(rightCallBack)
        }
    }
    // 下拉标签
    if (isShowDrop) {
        val dropView = toolbar.findViewById<View>(R.id.iv_drop_down)
        dropView.visibility = View.VISIBLE
        toolbar.findViewById<View>(R.id.ll_title_bar).setOnClickListener {
            if (it.tag == null) {
                dropView.rotate(360f)
                it.tag = true
            } else {
                it.tag = null
                dropView.rotate(180f)
            }
        }
    }
}

/**
 * Fragment使用
 *
 * @param toolbar        针对的toolbar
 * @param title         标题
 * @param isReturn      是否有返回键盘
 * @param rightRes      右侧图标
 * @param rightCallBack 右侧点击回调
 * @param isShowDrop    是否显示标题旁边的下拉标签，用于动画
 */
public inline fun RxFragment.setToolbarTitle(
        toolbar: Toolbar,
        title: String,
        @DrawableRes rightRes: Int = 0,
        rightCallBack: View.OnClickListener? = null,
        isShowDrop: Boolean = false
) {
    toolbar.findViewById<TextView>(R.id.tv_actionbar_title).text = title
    // 是否有右侧图标
    if (rightRes != 0) {
        toolbar.findViewById<View>(R.id.ll_right_bar).visibility = View.VISIBLE
        toolbar.findViewById<ImageView>(R.id.iv_right_image).setImageResource(rightRes)
        //监听
        if (rightCallBack != null) {
            toolbar.findViewById<View>(R.id.ll_right_bar).setOnClickListener(rightCallBack)
        }
    }
    // 下拉标签
    if (isShowDrop) {
        val dropView = toolbar.findViewById<View>(R.id.iv_drop_down)
        dropView.visibility = View.VISIBLE
        toolbar.findViewById<View>(R.id.ll_title_bar).setOnClickListener {
            if (it.tag == null) {
                dropView.rotate(360f)
                it.tag = true
            } else {
                it.tag = null
                dropView.rotate(180f)
            }
        }
    }
}


/**
 * Activity使用
 * @param toolbar        针对的toolbar
 * @param title         标题
 * @param isReturn      是否有返回键盘
 * @param rightRes      右侧图标
 * @param rightCallBack 右侧点击回调
 * @param isShowDrop    是否显示标题旁边的下拉标签，用于动画
 * @param showDropCallBack   点击标题  弹出下拉框
 */
public inline fun RxAppCompatActivity.setToolbarTitle(
        toolbar: Toolbar,
        title: String,
        isReturn: Boolean = false,
        @DrawableRes rightRes: Int = 0,
        rightCallBack: View.OnClickListener? = null,
        isShowDrop: Boolean = false,
        showDropCallBack: View.OnClickListener? = null
) {
    toolbar.findViewById<TextView>(R.id.tv_actionbar_title).text = title
    // 是否带返回键
    if (isReturn) {
        toolbar.setNavigationIcon(R.drawable.left_out)
        toolbar.setNavigationOnClickListener { finish() }
    }
    // 是否有右侧图标
    if (rightRes != 0) {
        toolbar.findViewById<View>(R.id.ll_right_bar).visibility = View.VISIBLE
        toolbar.findViewById<ImageView>(R.id.iv_right_image).setImageResource(rightRes)
        //监听
        if (rightCallBack != null) {
            toolbar.findViewById<View>(R.id.ll_right_bar).setOnClickListener(rightCallBack)
        }
    } else {
        toolbar.findViewById<View>(R.id.ll_right_bar).visibility = View.GONE
    }
    // 下拉标签
    if (isShowDrop) {
        val dropView = findViewById<View>(R.id.iv_drop_down)
        dropView.visibility = View.VISIBLE
        findViewById<View>(R.id.ll_title_bar).setOnClickListener {
            if (it.tag == null) {
                dropView.rotate(180f)
                it.tag = true
            } else {
                dropView.rotate(360f)
                it.tag = null
            }
            // 回调
            showDropCallBack?.onClick(it)
        }
    }
}
