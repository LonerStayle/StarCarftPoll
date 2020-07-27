package com.example.starcarftpoll.view.fragment

import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.view.animation.AnimationUtils
import com.example.starcarftpoll.R
import com.example.starcarftpoll.databinding.FragmentGuideBinding
import com.example.starcarftpoll.view.viewbase.BaseFragment


 class GuideFragment : BaseFragment<FragmentGuideBinding>(R.layout.fragment_guide) {
   private val backgroundimage by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.guide_imagebackground
        )
    }
   private val startbtnAni by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.guide_btnstart
        )
    }


    private val dp by lazy { resources.displayMetrics.density }


    override fun FragmentGuideBinding.setOnCreateView() {

        guideAnimationFirst()

        var clickCount = 0
        buttonGuidetoGame.setOnClickListener {
            clickCount++
            if (clickCount == 1) {
                guideAnimationButtonClickAfter()
            } else if (clickCount <= 2) {
                goToAction.gotoGame(root)
                clickCount = 0
            }
        }
    }

    private fun guideAnimationFirst() {

        binding.apply {
            buttonGuidetoGame.animate().translationY(150 * dp).setDuration(10L).withStartAction {
                arrow.animate().translationY(150 * dp).setDuration(10L).withEndAction {
                    buttonGuidetoGame.visibility = View.VISIBLE
                    arrow.visibility = View.VISIBLE
                }.start()
            }.start()
        }
    }

    private fun guideAnimationButtonClickAfter() {

        binding.apply {
            buttonGuidetoGame.animate().translationY(0f).setDuration(10L)
                .withStartAction {
                    arrow.visibility = View.INVISIBLE
                    buttonGuidetoGame.visibility = View.INVISIBLE
                    textViewGuide.visibility = View.VISIBLE
                    imageViewBackground.visibility = View.VISIBLE
                    imageViewBackground.startAnimation(backgroundimage)

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