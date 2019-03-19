package com.ssf.tc.publish

import com.funtsui.dell.kotlindarggermvvm.R
import com.funtsui.dell.kotlindarggermvvm.base.JectPackActivity
import com.funtsui.dell.kotlindarggermvvm.databinding.ActivityPublishTestBinding
import com.ssf.tc.publish.vm.PublishTestViewModel

/**
 * Created by zhg on 2019/3/19.
 */
class PublishTestActivity : JectPackActivity<ActivityPublishTestBinding>(R.layout.activity_publish_test){
    val reslut by lazy {
        viewModelProvider.get(PublishTestViewModel::class.java)
    }
    override fun init() {
        binding.vm=reslut
    }

    override fun initStatusBar() {

    }

}