package com.funtsui.dell.kotlindarggermvvm.net

/**
 * Created by zhg on 2019/3/18.
 */
class ApiException(
    val code:CodeException,
    // 状态吗
    val statusCode:Int,
    // 数据
    val displayMessage:String
):Throwable()