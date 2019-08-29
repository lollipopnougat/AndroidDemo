# AndroidDemo

## Big Number Game

### 大数游戏

#### 简介

就是我真正自己编写的第一个安卓程序，踩了不少坑<br>

此项目的特点:

* 使用了 `AndroidX`
* 使用 `JDK12`
* 使用 `IntelliJ IDEA 2019.1.4` 开发

#### 后记

把 `IntelliJ IDEA` 调教成了我自定义的 `Android Studio` <br>
在国内果然搞这种开发很不方便呐，需要配置很多网络镜像啊代理啊的东西<br>
至于怎样使用国内镜像<br>
把下面两句加入 `IJ` 或 `Android Studio` 的 **Project** 下的 `build.gradle`里的两个 `repositories` 里面

```gradle
maven { url 'https://maven.aliyun.com/repository/google' }
maven { url 'https://maven.aliyun.com/repository/jcenter' }
```

毕竟TC网络出关口有个那什么<br>
还好我这里网络不错，能够直接从 `dl.google.com` 下到 `SDK` 和 `AVD Images` <br>
`IntelliJ IDEA`也会时不时报个什么插件错误出来，不过倒不影响使用<br>
关于 `Java12`: 从 `Java9` 开始JAVA的结构发生了些许变化，某些功能被模块化放入了其他的包中<br>
至于解决 `Android SDK Manager` 等工具对原 `Java EE` 中的功能的依赖<br>
参考[stack overflow](https://stackoverflow.com/questions/53076422/getting-android-sdkmanager-to-run-with-java-11)<br>
如果你在 `Windows` 平台上也可以使用那个 `bash` 脚本
请打开 `PowerShell`， `cd` 到你的 `Android SDK` 目录，然后执行

```powershell
mkdir jaxb_lib
wget http://central.maven.org/maven2/javax/activation/activation/1.1.1/activation-1.1.1.jar -O jaxb_lib/activation.jar
wget http://central.maven.org/maven2/javax/xml/jaxb-impl/2.1/jaxb-impl-2.1.jar -O jaxb_lib/jaxb-impl.jar
wget http://central.maven.org/maven2/org/glassfish/jaxb/jaxb-xjc/2.3.2/jaxb-xjc-2.3.2.jar -O jaxb_lib/jaxb-xjc.jar
wget http://central.maven.org/maven2/org/glassfish/jaxb/jaxb-core/2.3.0.1/jaxb-core-2.3.0.1.jar -O jaxb_lib/jaxb-core.jar
wget http://central.maven.org/maven2/org/glassfish/jaxb/jaxb-jxc/2.3.2/jaxb-jxc-2.3.2.jar -O jaxb_lib/jaxb-jxc.jar
wget http://central.maven.org/maven2/javax/xml/bind/jaxb-api/2.3.1/jaxb-api-2.3.1.jar -O jaxb_lib/jaxb-api.jar
```

然后打开你的`sdkmanager.bat`，定位到 `66` 行，将依赖的jar地址加上

