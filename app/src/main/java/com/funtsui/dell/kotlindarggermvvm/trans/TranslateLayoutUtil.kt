package com.funtsui.dell.kotlindarggermvvm.trans

import android.graphics.drawable.AnimationDrawable
import android.support.v4.util.SimpleArrayMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.funtsui.dell.kotlindarggermvvm.R
import com.funtsui.dell.kotlindarggermvvm.enum.IStateLayout

public class TranslateLayoutUtil(
    /* 綁定的布局 */
    private val mBindView: ViewGroup
) {
    /** 自定义layout */
    private val mRootStateLayout by lazy {
        val rootStateLayout = LayoutInflater.from(mBindView.context).inflate(R.layout.layout_state, mBindView, false)
        rootStateLayout.visibility = View.GONE
        rootStateLayout
    }
    /** 加载中的布局 */
    private val mLoadingViewAnimationDrawable: AnimationDrawable by lazy {
        mRootStateLayout.findViewById<ImageView>(R.id.arr_loadView).drawable as AnimationDrawable;
    }
    /** 状态布局，当前呈现的状态 */
    private var mStateLayout = IStateLayout.LOADING
    /** 被隐藏的布局,存储用于后期恢复 */
    private val mCookieLayouts = SimpleArrayMap<View, Int>()

    init {
        mBindView.addView(mRootStateLayout, 0)
    }


    /** 布局加载完成时,初始化加载中布局  */
    fun onFinishInflate() {
        updateLayout()
    }

    /**
     * 获取状态布局
     * @return
     */
    fun getStateLayout(): IStateLayout {
        return mStateLayout
    }

    /**
     * 刷新状态布局
     */
    fun setStateLayout(stateLayout: IStateLayout) {
        mStateLayout = stateLayout
        updateLayout()
    }

    /**
     * 更新布局
     */
    private fun updateLayout() {
        when (mStateLayout) {
            //加载中
            IStateLayout.LOADING -> {
                isShowMainLayout(false)
                mBindView.findViewById<View>(R.id.arr_rl_loading).visibility = View.VISIBLE
                mBindView.findViewById<View>(R.id.arr_rl_empty).visibility = View.GONE
                mBindView.findViewById<View>(R.id.arr_rl_refresh).visibility = View.GONE
                mLoadingViewAnimationDrawable.start()
            }
            //正常
            IStateLayout.NORMAL -> {
                isShowMainLayout(true)
                mBindView.findViewById<View>(R.id.arr_rl_loading).visibility = View.VISIBLE
                mBindView.findViewById<View>(R.id.arr_rl_empty).visibility = View.GONE
                mBindView.findViewById<View>(R.id.arr_rl_refresh).visibility = View.GONE
                mLoadingViewAnimationDrawable.stop()
            }
            //为空
            IStateLayout.EMPTY -> {
                isShowMainLayout(false)
                mBindView.findViewById<View>(R.id.arr_rl_loading).visibility = View.GONE
                mBindView.findViewById<View>(R.id.arr_rl_empty).visibility = View.VISIBLE
                mBindView.findViewById<View>(R.id.arr_rl_refresh).visibility = View.GONE
                mLoadingViewAnimationDrawable.stop()
            }
            //重新刷新
            IStateLayout.REFRESH -> {
                isShowMainLayout(false)
                mBindView.findViewById<View>(R.id.arr_rl_loading).visibility = View.GONE
                mBindView.findViewById<View>(R.id.arr_rl_empty).visibility = View.GONE
                mBindView.findViewById<View>(R.id.arr_rl_refresh).visibility = View.VISIBLE
                mLoadingViewAnimationDrawable.stop()
            }
            else -> mLoadingViewAnimationDrawable.stop()
        }
    }

    /**
     * 是否隐藏主布局
     */
    private fun isShowMainLayout(isShow: Boolean) {
        val rootStateLayout = mBindView.getChildAt(0)
        val rootVisibility = rootStateLayout.visibility
        if (isShow) {
            if (rootVisibility != View.GONE) {
                //隐藏加载中的布局
                rootStateLayout.visibility = View.GONE
                //恢复这些布局原本的状态
                for (i in 0 until mCookieLayouts.size()) {
                    val view = mCookieLayouts.keyAt(i)
                    val state = mCookieLayouts.valueAt(i)
                    when (state) {
                        View.VISIBLE -> view.visibility = View.VISIBLE
                        View.INVISIBLE -> view.visibility = View.INVISIBLE
                        View.GONE -> view.visibility = View.GONE
                        else -> {
                        }
                    }
                }
            }
        } else {
            if (rootVisibility != View.VISIBLE) {
                //显示加载中的布局
                rootStateLayout.visibility = View.VISIBLE
                //隐藏布局
                mCookieLayouts.clear()
                val childCount = mBindView.childCount
                for (i in 1 until childCount) {
                    val childAt = mBindView.getChildAt(i)
                    val visibility = childAt.visibility
                    mCookieLayouts.put(childAt, visibility)
                    childAt.visibility = View.GONE
                }
            }

        }


    }

    /**
     * 恢复加载布局动画
     */
    fun recoveryLoadingLayout() {
        if (mStateLayout === IStateLayout.LOADING && mLoadingViewAnimationDrawable.isRunning) {
            mLoadingViewAnimationDrawable.start()
        }
    }
}