package com.funtsui.dell.kotlindarggermvvm.vm

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import javax.inject.Inject

open class AppViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
}