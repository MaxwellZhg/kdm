package com.funtsui.dell.kotlindarggermvvm.download

import android.content.Context
import com.socks.library.KLog

/**
 * Created by zhg on 2019/3/21.
 */
class DownloadService {

    companion object {
        /**
         * 下载更新数据库
         */
        fun update(context: Context, downloadUrl: String, readCount: Long, totalCount: Long, done: Boolean) {
            val downInfo = DownInfoDbUtil.getInstance(context).query(downloadUrl)
            if (downInfo != null && downInfo.state != DownState.PAUSE) {
                // 之前的进度，避免重复刷新
                val preProgress = (downInfo.readLength * 1.0 / downInfo.countLength * 100.0).toInt()
                // 写入当前读入的值
                var readLength = readCount
                if (downInfo.countLength > totalCount) {
                    readLength += downInfo.countLength - totalCount
                } else {
                    downInfo.countLength = totalCount
                }
                downInfo.readLength = readLength
                // 计算进度
                val progress = downInfo.progress
                if (done) {
                    KLog.e("完成了....")
                }
                // 完成
                if (progress != preProgress) {
                    // 刷新数据库
                    DownInfoDbUtil.getInstance(context).update(downInfo)

                }
            }
        }
    }
}


