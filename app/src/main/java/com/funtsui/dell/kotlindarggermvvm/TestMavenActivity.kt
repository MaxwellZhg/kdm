package com.funtsui.dell.kotlindarggermvvm

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.funtsui.dell.kotlindarggermvvm.base.BaseFragment
import com.funtsui.dell.kotlindarggermvvm.base.JectPackActivity
import com.funtsui.dell.kotlindarggermvvm.bean.MainTab
import com.funtsui.dell.kotlindarggermvvm.databinding.ActivityTestMavenBinding
import com.funtsui.dell.kotlindarggermvvm.ui.FreeFragment
import com.funtsui.dell.kotlindarggermvvm.ui.HistoryFragment
import com.funtsui.dell.kotlindarggermvvm.ui.PlayFragment
import com.funtsui.dell.testmavenlib.vm.TestMavenViewModel
import com.ssf.tc.strategy.ShelvesStrategy


class TestMavenActivity:JectPackActivity<ActivityTestMavenBinding>(
    R.layout.activity_test_maven,
    swapeBackLayoutEnable = true
  ){
    private val viewModel by lazy {
        viewModelProvider.get(TestMavenViewModel::class.java)
    }
    override fun init() {
        binding.tabhost.setup(this, supportFragmentManager, R.id.fragment_container)
        createTabList().forEach {
            var tabSpace =  binding.tabhost.newTabSpec(it.text).setIndicator(createTabItemView(it.text,it.icon))
            binding.tabhost.addTab(tabSpace,it.fragmentClass,null)

        }
        binding.tabhost.setOnTabChangedListener {
            tabId ->
            val fragment = supportFragmentManager.findFragmentByTag(tabId) as? BaseFragment
            fragment?.refresh()
        }
        ShelvesStrategy().next(this)
    }

    override fun initStatusBar() {
       super.initStatusBar()
    }

    private fun createTabList() = ArrayList<MainTab>().apply {
        add(MainTab(FreeFragment::class.java, resources.getString(R.string.main_zhg_tab_free), R.drawable.select_tab_main_free))
        add(MainTab(HistoryFragment::class.java, resources.getString(R.string.main_zhg_tab_hisory), R.drawable.select_tab_main_history))
        add(MainTab(PlayFragment::class.java, resources.getString(R.string.main_zhg_tab_play), R.drawable.select_tab_main_play))
    }

    private fun createTabItemView(title: String, resId: Int): View =
        layoutInflater.inflate(R.layout.item_publish_main_zhg_tab, null)
            .apply {
                val tvTitle = findViewById<TextView>(R.id.tv_title)
                tvTitle.visibility = View.VISIBLE
                tvTitle.text = title
                val icon = findViewById<ImageView>(R.id.iv_icon)
                icon.setImageResource(resId)
            }

/*    override fun onClick(v: View) {
       when(v!!.id){
            R.id.detail->{
                viewModel.detail(v)
            }
        }
    }*/

}
