package com.example.starcarftpoll.view.animation

import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import com.example.starcarftpoll.R
import com.example.starcarftpoll.view.fragment.GameFragment
import kotlinx.android.synthetic.main.fragment_guide.view.*

class GuideFragmentAnimation: GameFragment() {


    fun guideAnimation_first(root:View,dp:Float) {
        root.button_GuidetoGame.animate().translationY(150 * dp).setDuration(10L).withStartAction {
            root.arrow.animate().translationY(150 * dp).setDuration(10L).withEndAction {
                root.button_GuidetoGame.visibility = View.VISIBLE
                root.arrow.visibility = View.VISIBLE
            }.start()
        }.start()
    }

    fun guideAnimation_ButtonClickAfter(root: View,backgroundimageAnimation:Animation,startbtnAni:Animation) {
        root.button_GuidetoGame.animate().translationY(0f).setDuration(10L)
            .withStartAction {
                root.arrow.visibility = View.INVISIBLE
                root.button_GuidetoGame.visibility = View.INVISIBLE
                root.textView_Guide.visibility = View.VISIBLE
                root.imageView_background.visibility = View.VISIBLE
                root.imageView_background.startAnimation(backgroundimageAnimation)

                root.button_GuidetoGame.animate().setStartDelay(1000).withEndAction {
                    root.button_GuidetoGame.text = "시작 하기"
                    root.button_GuidetoGame.setTextColor(Color.WHITE)
                    root.button_GuidetoGame.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
                    root.button_GuidetoGame.setBackgroundResource(R.drawable.guide_buttonbackground)
                    root.button_GuidetoGame.startAnimation(startbtnAni)
                }.start()
            }.start()

    }
}