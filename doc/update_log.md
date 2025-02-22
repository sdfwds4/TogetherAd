# 更新日志

## 5.0.2

2021.04.26

1. 对应版本：穿山甲3.6.1.0；优量汇4.351.1221；百度5.91
2. 更新了穿山甲和优量汇的SDK
3. 全屏视频广告添加了视频播放完成的回调 onVideoComplete

## 5.0.1

2021.04.19

1. 对应版本：穿山甲3.6.0.0；优量汇4.333.1203；百度5.91
2. 更新了穿山甲的SDK
3. 优化 TTAdManager 的获取方式，全局使用一个，可以减少内存开支
4. 新增可以设置夜间模式的接口 TogetherAdCsj.themeStatus = 1 或者 TogetherAdCsj.mTTAdManager.themeStatus = 1

## 5.0.0

2021.04.11

1. 对应版本：穿山甲3.5.5.0；优量汇4.333.1203；百度5.91
2. 项目远程仓库迁移到Jitpack，由于Jitpack不支持自定义groupId、artifactId和版本号规则，所以依赖路径有相应的变化，需要自行按照文档进行修改

## 4.1.9

2021.04.06

1. 更新穿山甲SDK 3.5.5.0（ 新增新插屏广告 ）

## 4.1.8

2021.03.24

1. 穿山甲的视频贴片广告合并到 AdHelperNativePro ( CsjProvider.Native.nativeAdType = AdSlot.TYPE_STREAM )，展示方式和原生自渲染一样

## 4.1.7

2021.03.22

1. 优量汇原生自渲染可以自定义广告标识的位置（ 重写 getLogoLayoutParams 方法 ）

## 4.1.5

2021.03.16

1. 原生自渲染广告支持快速添加关闭按钮

## 4.1.4

2021.03.15

1. 新增穿山甲的自渲染贴片广告
2. 优量汇支持了全屏视频广告
3. 优量汇添加下载确认的弹窗，可自定义: TogetherAdGdt.downloadConfirmListener = DownloadConfirmHelper.DOWNLOAD_CONFIRM_LISTENER
4. 更新穿山甲SDK到 v3.5.0.3
5. 更新优量汇SDK到 v4.333.1203

## 4.1.3

2021.03.02

1. 更新穿山甲SDK到 v3.5.0.1

## 4.1.2

2021.02.06

1. 更新优量汇SDK到 v4.330.1202 （ 修复插屏全屏视频、激励视频、激励浏览可能遇到的崩溃问题 ）
2. 更新穿山甲SDK到 v3.4.5.0 ( https://bytedance.feishu.cn/docs/doccnhkyP8kSJZGDus7C5UsMdgc#l67FVr ) 【新增】SDK初始化增加异步初始化方式和初始化完成回调，且必须在主线程调用初始化方法;【优化】SDK初始化逻辑优化，同步初始化方式必须在主线程中调用;【废弃】TTAdConfig.Builder中asyncInit()方法废弃;
3. TogetherAd 对穿山甲初始化API的变化进行了适配: TogetherAdCsj.initCallback
4. 新增热启动开屏示例

## 4.1.1

2021.01.20

1. 更新优量汇SDK到 v4.330.1200 ( 激励视频支持server to server通知、开屏支持预拉取，开屏支持滑动引导手势，激励视频、插屏全屏视频的倒计时和关闭按钮优化，视频广告支持动态营销挂件等功能。 )

## 4.1.0

2021.01.16

1. 更新穿山甲SDK到 v3.4.1.2

## 4.0.9

2021.01.12

1. 全部请求失败也返回错误日志: onAdFailedAll(failedMsg: String?)
2. 更新穿山甲SDK到 v3.4.1.0

## 4.0.7

2020.12.23

1. 每个广告位的分发方式可以单独设置: TogetherAd.mDispatchTypeMap[TogetherAdAlias.AD_SPLASH] = DispatchType.xxxxxx

## 4.0.6

2020.12.22

1. 每个广告位的ID可以单独设置，例：TogetherAdCsj.idMapCsj[TogetherAdAlias.AD_SPLASH] = "xxxxxxxx"

## 4.0.5

2020.12.17

1. 激励广告 show 方法新增返回值，是否展示成功
2. 每个广告平台的开屏广告超时时间默认都改为 4000ms

## 4.0.4

2020.12.15

1. 原生自渲染可自定义点击 List<View>
2. 原生自渲染的容器在展示前后自动removeAllViews

## 4.0.3

2020.12.09

1. 更新优量汇版本到 4.310.1180（ 新增开屏V+样式，支持视频边下边播，支持新游预约广告，插屏全屏视频支持试玩；提升开屏广告加载速度，修复其它已知问题 ）

## 4.0.2

2020.12.03

1. 支持穿山甲的全屏视频广告
2. 添加 TogetherAd.allListener 方便做统计
3. 添加广告分发优先级模式 TogetherAd.dispatchType = DispatchType.Priority

## 4.0.1

2020.12.01

1. 穿山甲开屏广告支持自定义跳过按钮
2. Banner 和 插屏广告改为模板的请求方式
3. 新增原生模板1.0和原生模板2.0混合使用

## 4.0.0

2020.11.30

1. 新增原生模板2.0、原生模板1.0
2. Demo UI 调整

## 3.2.6

2020.11.24

1. 更新优量汇版本到 4.294.1164（ 修复开屏视频广告可能发生的崩溃问题 ）
2. 更新穿山甲版本到 3.3.0.3
3. 新增 加载和展示分开的开屏广告 AdHelperSplashPro，可实现预加载

## 3.2.5

2020.11.05

1. 更新优量汇版本到 4.291.1161（ 修复开屏视频挂件在开屏结束后可能没有消失的问题；修复插屏 2.0 广告在Android8.x 系统中，当 Activity 使用透明主题时可能崩溃的问题。 ）

## 3.2.4

2020.11.04

1. 更新穿山甲版本到 3.3.0.1
2. 更新优量汇版本到 4.290.1160

## 3.2.3

2020.10.28

1. 修复部分机型DefaultImageLoader崩溃(#25)
2. 原生自渲染参数可空
3. 修复开启混淆后广点通初始化错误的问题(#24)

## 3.2.1

2020.10.23

1. 穿山甲 loadBannerAd -> loadBannerExpressAd（ 穿山甲目前只支持模板类型Banner，如果你还想继续使用loadBannerAd ）[详情查看文档](doc/extend.md)
2. 改为不设置ratioMap的情况下默认不展示广告
3. 删除了所有 Deprecated.
4. 将各个平台的 Provider 开放出来，如果现有的 Provider 不满足你的需求可以自定义扩展。[详情查看文档](doc/extend.md)

## 3.2.0

2020.10.13

1. radio -> ratio ( 比例，英文单词拼写错误纠正 )

## 3.1.9

2020.09.28

1. 封装原生信息流Base，自定义模板更简单

## 3.1.8

2020.09.15

1. 更新SDK版本：穿山甲v3.2.5.1；广点通v4.270.1140；百青藤v5.91

## 3.1.7

2020.09.10

1. 开屏广告：广点通和穿山甲支持自定义超时时间，另外穿山甲还支持设置图片尺寸避免变形 [详情查看文档](doc/splash.md)
2. 原生自渲染：广点通支持自定义一些参数  [详情查看文档](doc/native.md)
3. Banner横幅广告：穿山甲支持设置刷新时间、图片尺寸 [详情查看文档](doc/banner.md)
4. Inter插屏广告：穿山甲支持设置图片尺寸 [详情查看文档](doc/inter.md)
5. 初始化：穿山甲新增初始化参数 [详情查看文档](doc/prepare.md)

## 3.1.6

2020.09.07

1. 激励广告支持穿山甲自定义请求参数 CsjProvider.Reward [详情查看文档](doc/reward.md)
2. 穿山甲原生广告设置类型的Api变为：CsjProvider.Native.nativeAdType = xxxxxx。不建议继续使用：AdHelperNativePro.csjNativeAdType = xxxxxx

## 3.1.5

2020.09.01

1. 新增原生自渲染的样例 NativeViewSimple1、NativeViewSimple2、NativeViewSimple3

### 3.1.4

2020.08.27

1. 所有种类广告支持超时逻辑

### 3.1.3

2020.08.26

1. 去掉所有库中 appcompat-v7 依赖

### 3.1.2

2020.08.25

1. 开屏广告支持超时逻辑

### 3.1.1

2020.08.19

1. 穿山甲原生广告需要设置类型 [详情查看文档](doc/native.md)

### 3.1.0

2020.08.12

1. 新增失败切换的开关 TogetherAd.failedSwitchEnable（ 默认开启 ）
2. Demo中提供混合使用的方案 [详情查看文档](doc/hybrid.md)
3. 解决开屏不设置自定义跳过按钮时广点通崩溃的问题
4. 处理 Demo 中一个内存泄漏的问题

### 3.0.9

2020.08.04

1. Log 日志开关
2. 由于设计缺陷 AdHelperNative 弃用，使用 AdHelperNativePro 替换
3. 原生自渲染广告的生命周期处理 [详情查看文档](doc/native.md)
4. 更新穿山甲SDK版本到3.1.0.1

### 3.0.8

2020.07.09

1. 资源库自带混淆规则，无需手动添加

### 3.0.7

2020.07.08

1. 添加插屏广告 && 修复穿山甲BannerBug && 激励Demo修改

### 3.0.6

2020.06.23

1. 初始化时可以不配置广告位ID，并单独提供配置广告位ID的api（ 考虑广告位ID由服务器下发的情况 ）
2. 修复其他已知bug

2020.06.30

1. 使用 RecyclerView.Adapter 演示 原生自渲染广告 在 RecyclerView 中的用法

### 3.0.5

2020.06.10

1. 修复 INSTALL_FAILED_CONFLICTING_PROVIDER ( Baidu 的 FileProvider 冲突问题 )

### 3.0.4

2020.06.08

1. 删除或替换项目中所有 androidx ( 为了兼容还在使用 Support 的项目 )
2. 优化csj自定义初始化配置的方式
3. 更新 百青藤v5.85，穿山甲v3.0.0.4

### 3.0.3

2020.05.27

1. 添加 Banner 横幅广告
2. 更新广点通的初始化方式
3. 修复激励广告内存泄漏问题
4. 添加踩坑指南
5. Demo中添加各个平台的测试ID
6. 提供 APK 预览体验
7. 全部失败的回调 onAdFailedAll() 删除失败原因参数

### 3.0.2

2020.05.20

1. 更新广点通SDK版本到 4.211.1081

### 3.0.1

2020.05.19  

1. 广告商SDK的aar文件打包到依赖中
2. 简化接入 TogetherAd 的流程

### 3.0.0

2020.05.18

1. 发布新版本 3.x
2. 支持开屏、原生自渲染、激励广告