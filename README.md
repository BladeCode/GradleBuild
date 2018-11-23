# GradleDeploy

* [master分支](https://github.com/BladeCode/GradleDeploy/tree/master)：采用gradle脚本实现多渠道配置编译，无第三方库集成
* [vasdolly分支](https://github.com/BladeCode/GradleDeploy/tree/vasdolly)：采用第三方库[VasDolly](https://github.com/Tencent/VasDolly)，多渠道配置方案

## 概要
解决问题：

* 同时打包Google Play，SamSung，XiaoMi等多个应用上架渠道，正式环境或测试环境安装包
* 支持测试环境，发布渠道应用可同时安装在一台设备上
* 自动匹配不同环境图标，应用名，API接口，渠道标识等参数

## 构建流程
![build](https://developer.android.google.cn/images/tools/studio/build-process_2x.png)
如图所示：Android应用模块的构建流程通常依循下列步骤：
1. 编译器将您的源代码转换成DEX（Dalvik Executable）文件（其中包括运行在Android设备上的字节码），将所有其他内容转换成已编译资源
2. APK打包器将DEX文件和已编译资源合并成单个APK。不过，必须先签署APK，才能将应用安装并部署到Android设备上
3. APK打包器使用调试或者发布密钥库签署您的APK：
    * 如果您构建的是调试版本的应用，打包器会使用调试密钥库签署您的应用。Android Studio自动使用调试密钥库配置新项目
    * 如果您构建的是打算向外发布的应用，打包器会使用发布密钥库签署您的应用。需要开发人员创建发布密钥库
4. 在生成最终APK之前，打包器会使用zipalign工具对应用进行优化，减少其在设备上运行时的内存占用

## 自定义构建配置
Android Studio 在项目初始化时已对项目进行了基础的构建配置，所谓的多渠道方式，只是在原有的配置基础上进行更细粒度的配置处理

主要配置点：
* BuildTypes：构建类型，Gradle在构建和打包您的应用时适用的某些属性，通常针对开发生命周期的不同阶段进行配置。
例如：调试构建类型支持调试选项，适用调试密钥签署APK；而发布构建类型则可压缩，混淆APK以及适用发布密钥签署APK进行发布。
* ProductFlavors：产品风味，表示您可以发布给用户的不同应用版本
例如：免费版和付费版
* BuildVariants：构建变体，是构建类型（BuildTypes）与产品风味（ProductFlavors）的交叉产物
* Signing：签署，构建系统让您能够在构建配置中指定签署设置，并可在构建过程中自动签署您的APK
* ProGuard：混淆，构建系统让您能够为每个构建变体（BuildVariants）指定不同的ProGuard规则文件
* 等等

## 总结
所有的处理方式，没有哪个一定比哪个好，只有在具体的场景下，哪个比哪个比较适合。

* gradle：适用项目小，对渠道的要求没有特别多
* VasDolly：项目较大，渠道要求比较多

## 附录
[配置构建](https://developer.android.google.cn/studio/build/)