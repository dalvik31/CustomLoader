package com.dalvik.loader


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dalvik.customloader.CustomLoader
import com.dalvik.customloader.Data

class MainActivity : AppCompatActivity() {
    private val customLoader: CustomLoader by lazy { CustomLoader(this, null) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Custom loader default
        //customLoader.show()

        //Custom loader only with lottie animation
        customLoader.show(Data( lottieAnimation = com.dalvik.customloader.R.raw.progress_default))

        //Custom loader change color progress default
        //customLoader.show(Data(progressColor = android.R.color.holo_blue_bright))

    }
}