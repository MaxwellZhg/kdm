package com.funtsui.dell.kotlindarggermvvm.trans

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.support.annotation.AttrRes
import android.util.AttributeSet
import com.funtsui.dell.kotlindarggermvvm.autolayout.AutoFrameLayout
import com.funtsui.dell.kotlindarggermvvm.enum.IStateLayout

open class TranslateFrameLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0) : AutoFrameLayout(context, attrs, defStyleAttr) {
    private val mLayoutUtil by lazy {
       TranslateLayoutUtil(this)
    }

    /**
     * 刷新状态布局
     */
    var stateLayout: IStateLayout
        get() = mLayoutUtil.getStateLayout()
        set(stateLayout) = mLayoutUtil.setStateLayout(stateLayout)


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mLayoutUtil.recoveryLoadingLayout()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mLayoutUtil.onFinishInflate()
    }


}
