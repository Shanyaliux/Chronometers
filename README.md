# Chronometer 

一个可以用来计时的控件，支持自定义时间间隔，多种显示格式的切换。  



## 效果演示



![](https://gitee.com/Shanya/PicBed/raw/master/Chronometer/demo.gif)



## 如何使用

### 添加依赖

------

- 在根目录的 `build.gralde` 添加以下代码：

```groovy
allprojects {
    repositories {
    //...省略原有代码
    maven { url 'https://jitpack.io' }
    }
}
```



- 在app目录的 `build.gralde` 添加以下代码：

```groovy
dependencies {
	//...省略原有代码
	implementation 'com.gitee.Shanya:Chronometers:V1.0.0'
}
```



### 常量及公共方法说明

------

#### 摘要

| 常量 |                            |
| :--- | -------------------------- |
| int  | DAYS_HOURS_MINUTES_SECONDS |
| int  | HOURS_MINUTES_SECONDS      |
| int  | MINUTES_SECONDS            |
| int  | SECONDS                    |

| 公共方法 |                            |
| -------- | -------------------------- |
| void     | setInterval(ms:Long)       |
| void     | setTimeType(timeType: Int) |
| void     | setTime(ms: Long)          |
| void     | start()                    |
| void     | stop()                     |

#### 常数

------

- **DAYS_HOURS_MINUTES_SECONDS**  
  - 显示格式为： xx 天 xx 时 xx 分 xx 秒
- **HOURS_MINUTES_SECONDS**
  - 显示格式为： xx 时 xx 分 xx 秒

- **MINUTES_SECONDS**
  - 显示格式为： xx 分 xx 秒
- **SECONDS**
  - 显示格式为： xx 秒



#### 公共方法

------

- setInterval(ms:Long)

  - 设置计时器的计时间隔，默认间隔为 1秒

  - 例如：间隔 1秒 

    ```kotlin
    chronometer.setInterval(1000)
    ```

    

-   setTimeType(timeType: Int)

  - 设置显示格式，默认显示格式为： xx 天 xx 时 xx 分 xx 秒

  - 例如： 显示 xx 秒   

    ```kotlin
    chronometer.setTimeType(Chronometer.SECONDS)
    ```

    

-  setTime(ms: Long)

  - 设置计时器的初值，默认初值时当前时间

  - 例如： 设置 2020/6/17 13:20   

    ```kotlin
    val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm")
    val date = simpleDateFormat.parse("2020/6/17 13:20")
    chronometer.setTime(date.time)
    ```

-  start()

  - 计时器开始计时

  - 例如：

    ```kotlin
    chronometer.start()
    ```

    

-  stop()

  - 计时器停止计时

  - 例如：

    ```kotlin
    chronometer.stop()
    ```

    
