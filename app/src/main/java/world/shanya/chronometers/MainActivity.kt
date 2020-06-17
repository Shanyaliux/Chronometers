package world.shanya.chronometers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import world.shanya.chronometer.Chronometer
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm")
        val date  = simpleDateFormat.parse("2020/6/16 11:05")

        chronometer.setTimeType(Chronometer.SECONDS)
        chronometer.setInterval(2000)
        chronometer.setTime(date.time)

        button.setOnClickListener {
            chronometer.start()
        }

    }
}