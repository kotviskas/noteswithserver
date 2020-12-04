package com.dvach.lab2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        private lateinit var lottieLayout: ConstraintLayout
        private lateinit var lottieAnimationView: LottieAnimationView

        fun enableSynchronizationAnimation() {
            lottieLayout.visibility = View.VISIBLE
            lottieAnimationView.playAnimation()
        }

        fun disableSynchronizationAnimation() {
            lottieLayout.visibility = View.INVISIBLE
            lottieAnimationView.pauseAnimation()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActivity.lottieLayout = lottieLayout
        MainActivity.lottieAnimationView = lottieAnimationView
    }
}
