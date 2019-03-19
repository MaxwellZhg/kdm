package com.funtsui.dell.testmavenlib.vm

import android.app.Application
import com.funtsui.dell.kotlindarggermvvm.vm.AppViewModel
import javax.inject.Inject

open class MavenAppViewModel @Inject constructor(application: Application) : AppViewModel(application)