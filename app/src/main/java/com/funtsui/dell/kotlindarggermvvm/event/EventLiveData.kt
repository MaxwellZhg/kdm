package com.funtsui.dell.kotlindarggermvvm.event

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer

open class EventLiveData<T> :SubscribeLiveData<Event<T>>(){

    fun postEvent(value:T){
        super.postValue(Event(value))
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<T>>) {
        throw IllegalAccessException("can not access this function,please use ObserverEvent")
    }

    override fun observeForever(observer: Observer<Event<T>>) {
        throw IllegalAccessException("can not access this function,please use observeEventForever")
    }
    /**
     * onActive状态下,检查消费，已消费不发送事件,意味着只要有一个Observer消费，其它observer就收不到消息
     */
    fun observeEvent(owner: LifecycleOwner,observer: Observer<T>):Observer<Event<T>>{
        val observerWrapper = EventObserverWrapper(observer)
        super.observe(owner,observerWrapper)
        return observerWrapper
    }

    /**
     * 所有状态下,检查消费，已消费不发送事件
     */
    fun observeEventForever(observer: Observer<T>):Observer<Event<T>>{
        val observerWrapper = EventObserverWrapper(observer)
        super.observeForever(observerWrapper)
        return observerWrapper
    }

    /**
     * onActive状态下,不检查消费始终发送事件
     */
    protected open fun observeEventUnCheckHandled(owner: LifecycleOwner,observer: Observer<T>):Observer<Event<T>>{
        val observerWrapper = EventObserverWrapper(observer,checkHandled = false)
        super.observe(owner,observerWrapper)
        return observerWrapper
    }

    /**
     * 所有状态下,不检查消费始终发送事件
     */
    protected open fun observeEventForeverUnCheckHandled(observer: Observer<T>):Observer<Event<T>>{
        val observerWrapper = EventObserverWrapper(observer,checkHandled = false)
        super.observeForever(observerWrapper)
        return observerWrapper
    }
    class EventObserverWrapper<T>(
        private val observer: Observer<T>,
        private val checkHandled: Boolean = true
    ) :Observer<Event<T>>{
        override fun onChanged(t: Event<T>?) {
             if(checkHandled){
                 t?.getDataIfNotHandled()?.apply {
                     observer.onChanged(this)
                 }
             }else{
                 observer.onChanged(t?.data)
             }
        }

    }
 }