package com.funtsui.dell.kotlindarggermvvm.bean

import android.support.annotation.DrawableRes

/**
 * Created by zhg on 2019/1/10.
 */
data class MainTab(val fragmentClass: Class<*>, var text: String, @field:DrawableRes var icon:Int )