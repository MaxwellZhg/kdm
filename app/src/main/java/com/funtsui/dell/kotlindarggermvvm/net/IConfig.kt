package com.funtsui.dell.kotlindarggermvvm.net

/**
 * Created by zhg on 2019/3/18.
 */

interface IConfig{
    companion object {
        val tag = "XNet"

        /**
         * 多域名，如果单域名不切换
         */
        var DOMAIN_URL = ""
        /**
         * 网络请求加载框 TAG
         */
        val NET_PROGRESS_TAG = "NET_PROGRESS_TAG"
    }
}