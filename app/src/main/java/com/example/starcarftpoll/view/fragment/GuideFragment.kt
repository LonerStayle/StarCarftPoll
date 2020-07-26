package com.example.starcarftpoll.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.starcarftpoll.R
import com.example.starcarftpoll.view.animation.GuideFragmentAnimation
import kotlinx.android.synthetic.main.fragment_guide.view.*


open class GuideFragment : Fragment() {
    val backgroundimage by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.guide_imagebackground
        )
    }
    val startbtnAni by lazy { AnimationUtils.loadAnimation(context,
        R.anim.guide_btnstart
    ) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dp by lazy { resources.displayMetrics.density }
        val root = inflater.inflate(R.layout.fragment_guide, container, false)
        val guideAnimation =
            GuideFragmentAnimation()

        guideAnimation.guideAnimation_first(root,dp)

        var clickCount = 0
        root.button_GuidetoGame.setOnClickListener {
            clickCount++
            if (clickCount == 1) {
                guideAnimation.guideAnimation_ButtonClickAfter(root,backgroundimage,startbtnAni)
            } else if (clickCount <= 2) {
                goToAction.gotoGame(root)
                clickCount = 0
            }
        }
        return root
    }


}