package com.funtsui.dell.kotlindarggermvvm.net

import android.app.Application

/**
 * Created by zhg on 2019/3/21.
 */
object AppCache{
    var  isPublish = false
    /**
     * application
     */
    lateinit var application: Application

    lateinit var lifecycleCallbacks: Application.ActivityLifecycleCallbacks

}