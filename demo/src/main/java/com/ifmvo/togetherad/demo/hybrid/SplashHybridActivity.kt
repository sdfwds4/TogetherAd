package com.ifmvo.togetherad.demo.hybrid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ifmvo.togetherad.core.custom.splashSkip.SplashSkipViewSimple2
import com.ifmvo.togetherad.core.listener.SplashListener
import com.ifmvo.togetherad.core.utils.loge
import com.ifmvo.togetherad.core.utils.logi
import com.ifmvo.togetherad.demo.AdProviderType
import com.ifmvo.togetherad.demo.R
import com.ifmvo.togetherad.demo.TogetherAdAlias
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * 开屏 & 原生 混合使用
 *
 * Created by Matthew Chen on 2020-04-17.
 */
class SplashHybridActivity : AppCompatActivity() {

    private val TAG = "SplashHybridActivity"

    companion object {
        fun action(context: Context) {
            context.startActivity(Intent(context, SplashHybridActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //开始请求开屏广告
        requestSplashAd()
    }

    /**
     * 请求开屏广告
     */
    private fun requestSplashAd() {

        /**
         * 自定义跳过按钮
         * TogetherAd 提供了两个简单的实例模板，同时只能设置一个,如果设置多个后面的生效
         * 目前只有 优量汇(广点通) 支持自定义跳过按钮的样式，所以只会对 广点通 生效
         */
        AdHelperSplashHybrid.customSkipView = SplashSkipViewSimple2()
//        SplashHybridAdapter.customSkipView = SplashSkipViewSimple1()

        //使用 Map<String, Int> 配置广告商 权重，通俗的讲就是 随机请求的概率占比
        val radioMapSplash = mapOf(
                AdProviderType.GDT.type to 0,
                AdProviderType.CSJ.type to 0,
                AdProviderType.BAIDU.type to 1
        )

        /**
         * activity: 必传。这里不是 Context，因为广点通必须传 Activity，所以统一传 Activity。
         * alias: 必传。广告位的别名。初始化的时候是根据别名设置的广告ID，所以这里TogetherAd会根据别名查找对应的广告位ID。
         * radioMap: 非必传。广告商的权重。可以不传或传null，空的情况 TogetherAd 会自动使用初始化时 TogetherAd.setPublicProviderRadio 设置的全局通用权重。
         * container: 必传。请求到广告之后会自动添加到 container 这个布局中展示。
         * listener: 非必传。如果你不需要监听结果可以不传或传空。各个回调方法也可以选择性添加
         */
        AdHelperSplashHybrid.show(activity = this, alias = TogetherAdAlias.AD_SPLASH_HYBRID, radioMap = radioMapSplash, container = adContainer, listener = object : SplashListener {

            override fun onAdStartRequest(providerType: String) {
                //在开始请求之前会回调此方法，失败切换的情况会回调多次
                addLog("\n开屏广告开始请求，$providerType")
                "onAdStartRequest: $providerType".logi(TAG)
            }

            override fun onAdLoaded(providerType: String) {
                //广告请求成功的回调，每次请求只回调一次
                addLog("开屏广告请求好了，$providerType")
                "onAdLoaded: $providerType".logi(TAG)
            }

            override fun onAdClicked(providerType: String) {
                //点击广告的回调
                addLog("开屏广告被点击了，$providerType")
                "onAdClicked: $providerType".logi(TAG)
            }

            override fun onAdExposure(providerType: String) {
                //广告展示曝光的回调
                addLog("开屏广告曝光了，$providerType")
                "onAdExposure: $providerType".logi(TAG)
            }

            override fun onAdFailed(providerType: String, failedMsg: String?) {
                //请求失败的回调，失败切换的情况会回调多次
                addLog("开屏广告单个提供商请求失败了，$failedMsg, $providerType")
                "onAdFailed: $providerType: $failedMsg".loge(TAG)
            }

            override fun onAdFailedAll() {
                //所有配置的广告商都请求失败了，只有在全部失败之后会回调一次
                addLog("全部请求失败了")
                "onAdFailedAll".loge(TAG)
                actionHome(1000)
            }

            override fun onAdDismissed(providerType: String) {
                //开屏广告消失了，点了跳过按钮或者倒计时结束之后会回调一次
                //在这里跳转主界面，并关闭 Splash
                addLog("开屏广告点了跳过或者倒计时结束， $providerType")
                "onAdDismissed: $providerType".logi(TAG)
                actionHome(0)
            }
        })
        //回调中的 providerType 是广告商类型
    }

    override fun onResume() {
        super.onResume()
        AdHelperSplashHybrid.resumeAd()
    }

    override fun onPause() {
        super.onPause()
        AdHelperSplashHybrid.pauseAd()
    }

    override fun onDestroy() {
        super.onDestroy()
//        AdHelperSplashHybrid.destroyAd()
    }

    //不能手动返回
    override fun onBackPressed() {}

    private fun actionHome(delayMillis: Long) {
        adContainer.postDelayed({
            //在这里跳转到 Home 主界面
            finish()
        }, delayMillis)
    }

    private var logStr = "日志: \n"

    private fun addLog(content: String?) {
        logStr = logStr + content + "\n"
        log.text = logStr

        info.post { info.fullScroll(View.FOCUS_DOWN) }
    }
}