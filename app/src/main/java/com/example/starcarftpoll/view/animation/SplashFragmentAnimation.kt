package com.example.starcarftpoll.view.animation

import android.content.res.ColorStateList
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.widget.ImageViewCompat
import androidx.databinding.ViewDataBinding
import com.example.starcarftpoll.R
import com.example.starcarftpoll.view.fragment.SplashFragment
import com.example.starcarftpoll.view.fragment.goToAction
import kotlinx.android.synthetic.main.fragment_splash.view.*

class SplashFragmentAnimation: SplashFragment() {


    fun splashAnimation(dp:Float) {
        binding.apply {
            textViewMoonClick.clearAnimation()
            textViewMoonClick.visibility = View.GONE
            imageButtonMoon.animate().translationY(-380f * dp).setDuration(800L)
                .setInterpolator(AccelerateDecelerateInterpolator())
                .withEndAction {
                    imageButtonMoon.setImageResource(R.drawable.splash_night_mode)
                    ImageViewCompat.setImageTintList(root.imageButton_moon, ColorStateList.valueOf(0))
                    imageButtonMoon.animate().rotation(360f).setDuration(600L)
                        .withEndAction {
                            goToAction.gotomain(root)
                        }.start()
                }.start()
        }

    }

}