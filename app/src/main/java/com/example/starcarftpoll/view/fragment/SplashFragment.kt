package com.example.starcarftpoll.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.starcarftpoll.R
import com.example.starcarftpoll.view.animation.SplashFragmentAnimation
import kotlinx.android.synthetic.main.fragment_splash.view.*


open class SplashFragment : Fragment() {
    val dp by lazy { resources.displayMetrics.density }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val splashanimation =
            SplashFragmentAnimation()
        var clickCount = 0
        val root = inflater.inflate(R.layout.fragment_splash, container, false)
        val moonAnimation = AnimationUtils.loadAnimation(context,
            R.anim.splash_textview_moon
        )

        root.textView_MoonClick.startAnimation(moonAnimation)

        root.imageButton_moon.setOnClickListener {
            clickCount++
            if (clickCount == 1) {
                splashanimation.splashAnimation(root,dp)
            }
        }
        return root

    }

}
