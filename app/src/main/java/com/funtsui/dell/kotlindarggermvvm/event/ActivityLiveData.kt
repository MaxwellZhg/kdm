package com.funtsui.dell.kotlindarggermvvm.event

import android.app.Activity
import android.content.Intent

class ActivityLiveData : EventLiveData<ActivityLiveData.Result>() {
    companion object {
        const val CMD_FINISH=1
        const val CMD_FINISH_RESULT=2
    }

    fun finish(){
        postEvent(Result(CMD_FINISH))
    }

    fun finishResult(resultCode:Int,data: Intent?=null){
        postEvent(Result(CMD_FINISH_RESULT,resultCode,data))
    }

    class Result(val cmd:Int, val resultCode:Int= Activity.RESULT_CANCELED, val data: Intent?=null)
}