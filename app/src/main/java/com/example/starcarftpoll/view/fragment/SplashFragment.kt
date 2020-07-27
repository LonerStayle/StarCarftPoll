package com.example.starcarftpoll.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.starcarftpoll.R
import com.example.starcarftpoll.databinding.FragmentSplashBinding
import com.example.starcarftpoll.view.animation.SplashFragmentAnimation
import com.example.starcarftpoll.view.viewbase.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.view.*


open class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

protected val dp by lazy{resources.displayMetrics.density}


    override fun FragmentSplashBinding.setOnCreateView() {

        val splashanimation =
            SplashFragmentAnimation()
        var clickCount = 0

        val moonAnimation = AnimationUtils.loadAnimation(context,
            R.anim.splash_textview_moon
        )

       textViewMoonClick.startAnimation(moonAnimation)

        imageButtonMoon.setOnClickListener {
            clickCount++
            if (clickCount == 1) {
                splashanimation.splashAnimation()
            }
        }
    }


}
