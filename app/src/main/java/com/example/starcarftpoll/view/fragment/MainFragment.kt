package com.example.starcarftpoll.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.starcarftpoll.R
import com.example.starcarftpoll.databinding.FragmentMainBinding
import com.example.starcarftpoll.view.animation.MainFragmentAnimation
import com.example.starcarftpoll.view.viewbase.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.view.*

open class MainFragment :BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

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
        val mainAnimation =
            MainFragmentAnimation()

        mainAnimation.mainAnimation(starCraftLogo,centerLogo, btnStart, btnGuide)

        buttonStart.setOnClickListener {
            goToAction.gotoStart(root)
        }
        buttonGuide.setOnClickListener {
            goToAction.gotoGuide(root)
        }
    }


}