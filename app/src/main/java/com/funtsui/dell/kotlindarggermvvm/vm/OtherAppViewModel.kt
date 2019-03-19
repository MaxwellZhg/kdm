package com.funtsui.dell.kotlindarggermvvm.vm

import android.app.Application
import javax.inject.Inject

/**
 * 全局 AppViewModel
 */
open class OtherAppViewModel @Inject constructor(application: Application) : AppViewModel(application)