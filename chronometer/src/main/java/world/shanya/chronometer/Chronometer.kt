package world.shanya.chronometer

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.text.SimpleDateFormat
import java.util.*

/**
 * @ClassName Chronometer
 * @Description 计时器控件
 * @Author Shanya
 * @Date 2020/6/16 15:39
 * @Version 1.0.0
 **/
class Chronometer : AppCompatTextView {

    constructor(context: Context) : this(context,null)
    constructor(context: Context,attributeSet: AttributeSet?) : this(context,attributeSet,0)
    constructor(context: Context,attributeSet: AttributeSet?,defStyleAttr: Int) : super(context,attributeSet,defStyleAttr)

    companion object{
        const val DAYS_HOURS_MINUTES_SECONDS = 0x966
        const val HOURS_MINUTES_SECONDS = 0x967
        const val MINUTES_SECONDS = 0x968
        const val SECONDS = 0x969
    }

    //时间显示格式
    private var timeType = DAYS_HOURS_MINUTES_SECONDS
    //是否自定义时间初值，如果没有则默认当前时间作为初值
    private var setTimeFlag = false
    //时间初值
    private var time:Long = 0
    //计时间隔
    private var interval:Long = 1000

    //计时器计时核心
    private val mHandler = Handler()
    private val runnable = object :Runnable{
        override fun run() {
            text = getTimeFromMs((getTimeDifference(time) + interval),timeType)
            mHandler.postDelayed(this,interval)
        }
    }

    fun setInterval(ms:Long){
        interval = ms
    }

    /**
    * 设置时间显示格式
    * @Author Shanya
    * @Date 2020/6/17 10:43
    * @Version 1.0.0
    */
    fun setTimeType(timeType: Int){
        this.timeType = timeType
    }

    /**
    * 设置时间计算初值
    * @Author Shanya
    * @Date 2020/6/17 9:35
    * @Version 1.0.0
    */
    fun setTime(ms: Long){
        setTimeFlag = true
        time = ms
    }

    /**
    * 开始计时
    * @Author Shanya
    * @Date 2020/6/17 9:38
    * @Version 1.0.0
    */
    fun start(){
        if (!setTimeFlag){
            setTimeFlag = true
            time = System.currentTimeMillis()
        }
        mHandler.postDelayed(runnable,0)
    }

    /**
    * 停止计时
    * @Author Shanya
    * @Date 2020/6/17 9:39
    * @Version 1.0.0
    */
    fun stop(){
        mHandler.removeCallbacks(runnable)
    }

    /**
    * 将毫秒格式时间转换成相应格式的字符串
    * @Author Shanya
    * @Date 2020/6/17 10:25
    * @Version 1.0.0
    */
    private fun getTimeFromMs(ms : Long,type : Int = DAYS_HOURS_MINUTES_SECONDS) : String{
        when(type){
            HOURS_MINUTES_SECONDS -> {
                val hours = ms / (1000 * 60 * 60)
                val minutes = (ms % (1000 * 60 * 60)) / (1000 * 60)
                val seconds = (ms % (1000 * 60)) / 1000
                return "$hours 小时 $minutes 分钟 $seconds 秒"
            }
            MINUTES_SECONDS -> {
                val minutes = ms / (1000 * 60)
                val seconds = (ms % (1000 * 60)) / 1000
                return "$minutes 分钟 $seconds 秒"
            }
            SECONDS -> {
                val seconds = ms / 1000
                return "$seconds 秒"
            }
            else -> {
                val days = ms / (1000 * 60 * 60 * 24)
                val hours = (ms % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
                val minutes = (ms % (1000 * 60 * 60)) / (1000 * 60)
                val seconds = (ms % (1000 * 60)) / 1000
                return "$days 天 $hours 小时 $minutes 分钟 $seconds 秒"
            }
        }
    }

    /**
    * 根据时间初值计算出相应的时间差
    * @Author Shanya
    * @Date 2020/6/17 10:18
    * @Version 1.0.0
    */
    private fun getTimeDifference(ms : Long) = System.currentTimeMillis() - ms

}