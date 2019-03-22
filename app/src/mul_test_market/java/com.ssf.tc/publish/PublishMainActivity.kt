package com.ssf.tc.publish

import android.content.Intent
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.R
import com.funtsui.dell.kotlindarggermvvm.base.JectPackActivity
import com.funtsui.dell.kotlindarggermvvm.databinding.ActivityPublishMainBinding
import com.funtsui.dell.kotlindarggermvvm.net.HttpService
import com.funtsui.dell.kotlindarggermvvm.net.IPublishConstantPool
import com.funtsui.dell.kotlindarggermvvm.net.convert
import com.socks.library.KLog
import org.jetbrains.anko.startActivity

/**
 * Created by zhg on 2019/1/21.
 */
class PublishMainActivity :JectPackActivity<ActivityPublishMainBinding>(R.layout.activity_publish_main,R.id.tv_content
,swapeBackLayoutEnable = false){

    override fun init() {
        KLog.e("tttttttt","111111")
        initData()
    }

    private fun initData() {
        val requestUrl = IPublishConstantPool.sCommonUrl+IPublishConstantPool.testUrl+"?channel_id=market"
        HttpService.officialApi.getShelvesInfo(requestUrl).convert(this, success = {
               KLog.e("tttttt",it.toString())
        }, error = {

        })
    }

    override fun initStatusBar() {

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_content->{
                val intent = Intent()
                intent.setClass(this,PublishTestActivity::class.java)
                startActivity(intent)
            }
        }
    }

}