package com.example.starcarftpoll.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.starcarftpoll.R
import com.example.starcarftpoll.view.animation.MainFragmentAnimation
import kotlinx.android.synthetic.main.fragment_main.view.*

open class MainFragment : Fragment() {

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val mainAnimation =
            MainFragmentAnimation()

        mainAnimation.mainAnimation(root,starCraftLogo,centerLogo, btnStart, btnGuide)

        root.button_Start.setOnClickListener {
            goToAction.gotoStart(root)
        }
        root.button_Guide.setOnClickListener {
            goToAction.gotoGuide(root)
        }

        return root
    }



}