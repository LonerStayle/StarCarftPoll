package com.example.starcarftpoll.view.animation

import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import com.example.starcarftpoll.R
import com.example.starcarftpoll.view.fragment.GameFragment
import com.example.starcarftpoll.view.fragment.GuideFragment
import kotlinx.android.synthetic.main.fragment_guide.view.*

class GuideFragmentAnimation : GuideFragment() {


    fun guideAnimationFirst() {

        binding.apply {
            buttonGuidetoGame.animate().translationY(150 * dp).setDuration(10L).withStartAction {
                arrow.animate().translationY(150 * dp).setDuration(10L).withEndAction {
                    buttonGuidetoGame.visibility = View.VISIBLE
                    arrow.visibility = View.VISIBLE
                }.start()
            }.start()
        }

    }

    fun guideAnimationButtonClickAfter(
        backgroundimageAnimation: Animation,
        startbtnAni: Animation
    ) {

        binding.apply {
            buttonGuidetoGame.animate().translationY(0f).setDuration(10L)
                .withStartAction {
                    arrow.visibility = View.INVISIBLE
                    buttonGuidetoGame.visibility = View.INVISIBLE
                    textViewGuide.visibility = View.VISIBLE
                    imageViewBackground.visibility = View.VISIBLE
                    imageViewBackground.startAnimation(backgroundimageAnimation)

                    buttonGuidetoGame.animate().setStartDelay(1000).withEndAction {
                        buttonGuidetoGame.apply {
                            text = "시작 하기"
                            setTextColor(Color.WHITE)
                            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
                            setBackgroundResource(R.drawable.guide_buttonbackground)
                            startAnimation(startbtnAni)
                        }

                    }.start()
                }.start()
        }


    }
}