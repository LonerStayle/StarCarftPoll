package com.example.starcarftpoll.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.starcarftpoll.R
import com.example.starcarftpoll.databinding.FragmentGuideBinding
import com.example.starcarftpoll.view.animation.GuideFragmentAnimation
import com.example.starcarftpoll.view.viewbase.BaseFragment
import kotlinx.android.synthetic.main.fragment_guide.view.*


open class GuideFragment : BaseFragment<FragmentGuideBinding>(R.layout.fragment_guide) {
    val backgroundimage by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.guide_imagebackground
        )
    }
    val startbtnAni by lazy { AnimationUtils.loadAnimation(context,
        R.anim.guide_btnstart
    ) }


        val dp by lazy { resources.displayMetrics.density }




    override fun FragmentGuideBinding.setOnCreateView() {
        val guideAnimation =
            GuideFragmentAnimation()

        guideAnimation.guideAnimation_first(dp)

        var clickCount = 0
        buttonGuidetoGame.setOnClickListener {
            clickCount++
            if (clickCount == 1) {
                guideAnimation.guideAnimation_ButtonClickAfter(backgroundimage,startbtnAni)
            } else if (clickCount <= 2) {
                goToAction.gotoGame(root)
                clickCount = 0
            }
        }
    }


}