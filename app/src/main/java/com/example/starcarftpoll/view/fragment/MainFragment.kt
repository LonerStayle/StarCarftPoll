package com.example.starcarftpoll.view.fragment

import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.starcarftpoll.R
import com.example.starcarftpoll.databinding.FragmentMainBinding
import com.example.starcarftpoll.view.viewbase.BaseFragment

class MainFragment :BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    val starCraftLogo by lazy { AnimationUtils.loadAnimation(context,
        R.anim.main_starcraftlogo
    ) }
    val centerLogo by lazy { AnimationUtils.loadAnimation(context,
        R.anim.main_somkecenter
    ) }
    val btnStart by lazy { AnimationUtils.loadAnimation(context,
        R.anim.main_buttonstart
    ) }
    val btnGuide by lazy { AnimationUtils.loadAnimation(context,
        R.anim.main_buttonguide
    ) }





    override fun FragmentMainBinding.setOnCreateView() {

      mainAnimation()

        buttonStart.setOnClickListener {
            goToAction.gotoStart(root)
        }
        buttonGuide.setOnClickListener {
            goToAction.gotoGuide(root)
        }
    }

   private fun mainAnimation() {
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