package com.ssf.tc.strategy

import android.app.Activity
import android.content.Intent
import com.ssf.tc.publish.PublishMainActivity

/*import com.ssf.framework.util.ex.SharedGetBoolean
import com.ssf.framework.util.ex.SharedPut
import com.ssf.tc.publish.PublishMainActivity
import com.ssf.tc.publish.activity.PublishMainActivity
import com.ssf.tckotlin.data.cache.AppCache
import com.ssf.tckotlin.data.network.IConstantPool
import com.ssf.tckotlin.ui.activity.MainActivity*/

/**
 * @author yedanmin
 * @data 2018/1/11 14:58
 * @describe 不同的上架模版，welcome中拥有不同的策略
 */

class ShelvesStrategy {

    /**
     * 不同的上架策略
     * @param activity       Activity对象
     * @param isPermission   权限是否申请成功
     */
    fun strategy(activity: Activity, isPermission: Boolean) {
        //什么都不干
    }

    /**
     * 倒计时完成进入下一步
     * @param activity
     */
    fun next(activity: Activity) {
      /*  val isOpenOfficial = activity.SharedGetBoolean(IConstantPool.Shared_Openfficial_Key)
        if (AppCache.isPublish && !isOpenOfficial) {
            activity.startActivity(Intent(activity, PublishMainActivity::class.java))
        } else {
            activity.SharedPut(IConstantPool.Shared_Openfficial_Key, true)
            activity.startActivity(Intent(activity, MainActivity::class.java))
        }*/
        activity.startActivity(Intent(activity, PublishMainActivity::class.java))
        activity.finish()
    }
}
