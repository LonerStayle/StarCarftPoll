package com.example.starcarftpoll.view.animation

import android.os.Handler
import android.view.View
import android.view.animation.Animation
import com.example.starcarftpoll.view.fragment.MainFragment
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragmentAnimation: MainFragment() {
    fun mainAnimation(starCraftLogo:Animation,centerLogo:Animation,btnStart:Animation,btnGuide:Animation) {
      binding.apply {

          imageViewStarCarftLogo.visibility = View.VISIBLE
          imageViewStarCarftLogo.startAnimation(starCraftLogo)

          imageViewCenterSmoke.visibility = View.VISIBLE
          imageViewCenterSmoke.startAnimation(centerLogo)

          Handler().postDelayed({
              buttonStart.visibility = View.VISIBLE
              buttonGuide.visibility = View.VISIBLE
              buttonStart.startAnimation(btnStart)
              buttonGuide.startAnimation(btnGuide)
          },500)
      }

    }
}



