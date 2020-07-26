package com.example.starcarftpoll.view.animation

import android.os.Handler
import android.view.View
import android.view.animation.Animation
import com.example.starcarftpoll.view.fragment.MainFragment
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragmentAnimation: MainFragment() {
    fun mainAnimation(root:View,starCraftLogo:Animation,centerLogo:Animation,btnStart:Animation,btnGuide:Animation) {
        root.imageView_StarCarftLogo.visibility = View.VISIBLE
        root.imageView_StarCarftLogo.startAnimation(starCraftLogo)

        root.imageView_CenterSmoke.visibility = View.VISIBLE
        root.imageView_CenterSmoke.startAnimation(centerLogo)

        Handler().postDelayed({
            root.button_Start.visibility = View.VISIBLE
            root.button_Guide.visibility = View.VISIBLE
            root.button_Start.startAnimation(btnStart)
            root.button_Guide.startAnimation(btnGuide)
        },500)
    }
}



