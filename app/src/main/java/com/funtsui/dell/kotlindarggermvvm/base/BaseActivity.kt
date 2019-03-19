package com.funtsui.dell.kotlindarggermvvm.base

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.funtsui.dell.kotlindarggermvvm.R
import com.funtsui.dell.kotlindarggermvvm.autolayout.AutoFrameLayout
import com.funtsui.dell.kotlindarggermvvm.autolayout.AutoLinearLayout
import com.funtsui.dell.kotlindarggermvvm.autolayout.AutoRelativeLayout
import com.funtsui.dell.kotlindarggermvvm.autolayout.widget.AutoConstraintLayout
import com.funtsui.dell.kotlindarggermvvm.inter.IConfig
import com.funtsui.dell.kotlindarggermvvm.ui.SwipeBackActivity
import com.jaeger.library.StatusBarUtil
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import java.util.*
import java.util.concurrent.TimeUnit

abstract class BaseActivity(
    //设置布局id
    private val layoutResID:Int,
    //设置点击事件id 为事件id数组
    private vararg val ids:Int= intArrayOf(0),
    //设置是否可以侧滑返回
   private val swapeBackLayoutEnable:Boolean=true,
   //状态栏颜色 沉浸式处理
   private val statusBarColor:Int =0,
   //状态栏的透明度
   private val statusBarAlpha : Int =0
) :SwipeBackActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()

        //对配置进行初始化
        initDefaultConfig()
    }

    open fun setContentView(){
        setContentView(layoutResID)
    }

    open fun initDefaultConfig(){
        //初始化状态栏
        initStatusBar()
        //设置是否划出
        setSwipeBackEnable(swapeBackLayoutEnable)
        //init 抽象初始化
        init()
        //初始化点击事件 依赖于rxjava 2.0
        initClickListener()
    }

    abstract fun init()

    open fun initClickListener(){
        //创建一个观察者对象，其中观察的变量是view
        val disposable= Observable.create(object :ObservableOnSubscribe<View>,View.OnClickListener{
            //定义事件发射型变量
            lateinit var emitter: ObservableEmitter<View>
            override fun subscribe(emitter: ObservableEmitter<View>) {
                this.emitter=emitter
                ids.forEach {
                    if(it!=0){
                        //事件返回界面全局监听
                        findViewById<View>(it).setOnClickListener(this)
                    }
                }
            }

            override fun onClick(v: View) {
                emitter.onNext(v)
            }

        }).compose(bindUntilEvent(ActivityEvent.DESTROY))//绑定观察事件的生命周期 rxlifecycle
                //设定事件长度发射
            .throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                onClick(it)
            }
    }

    open fun initStatusBar(){
        if (statusBarColor != 0) {
            StatusBarUtil.setColor(this, statusBarColor)
        } else {
            StatusBarUtil.setTranslucentForImageView(this, 0, findViewById(R.id.toolbar))
        }
    }

    override fun onClick(v: View?) {
        val disposable= Observable.just(v)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return when(name){
            IConfig.LAYOUT_FRAMELAYOUT -> AutoFrameLayout(context, attrs)
            IConfig.LAYOUT_LINEARLAYOUT -> AutoLinearLayout(context, attrs)
            IConfig.LAYOUT_RELATIVELAYOUT -> AutoRelativeLayout(context, attrs)
            IConfig.LAYOUT_CONSTRAINTLAYOUT -> AutoConstraintLayout(context, attrs)
            else -> super.onCreateView(name, context, attrs)
        }
    }
}