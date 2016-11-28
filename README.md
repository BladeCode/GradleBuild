# GradleDeploy
Gradle配置Android项目
## build.gradle
* build.gradle(Project)
gradle 配置文件基于整个Project的配置
* build.gradle(Module)
gradle 配置文件基于每个Module自己的配置  

## gradle.properties
该文件主要用来定义一些常量提供给build.gradle使用
比如：签名相关信息（keystore位置，密码，keyalias等）  

## settings.gradle
该文件用来配置多模块，比如项目中有两个模块module-a,module-b;那么在该文件中进行配置，格式如下：  
```gradle
include ':module-a',':module-b'
```

## gradlew和gradlew.bat
* gradlew 是linux下shell脚本  
* gradlew.bat 是windows下的批处理文件
这两个文件的作用是根据gradle-wrapper.properties文件中distributionUrl下载对应的gradle版本。这样就可以保证在不同的环境下构建时都是使用统一的gradle，即使该环境没有安装gradle也可以，因为gradle wrapper会自动下载对应的gradle版本。

## 详细使用及说明
[wiki](https://github.com/BladeCode/GradleDeploy/wiki)