package com.funtsui.dell.kotlindarggermvvm.download

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * Created by zhg on 2019/3/21.
 */
interface IDownloadService{
    /*大文件需要加入这个判断，防止下载过程中写入到内存中*/
    @Streaming
    @GET
    fun download(@Header("RANGE") start: String, @Url url: String): Observable<ResponseBody>
}