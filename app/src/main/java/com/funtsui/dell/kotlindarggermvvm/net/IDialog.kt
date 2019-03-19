package com.funtsui.dell.kotlindarggermvvm.net

/**
 * Created by zhg on 2019/3/18.
 */
enum class IDialog{
    //不显示进度条
    UN_LOADING,
    //显示进度条 -> 点击空白出可以取消 -> 放心年轻人  取消自动取消队列
    NORMAL_LOADING,
    //显示进度条 -> 点击空白处 不可取消
    FORBID_LOADING;
}