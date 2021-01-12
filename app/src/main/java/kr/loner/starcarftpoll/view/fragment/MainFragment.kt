package kr.loner.starcarftpoll.view.fragment

import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import kr.loner.starcarftpoll.R
import kr.loner.starcarftpoll.databinding.FragmentMainBinding
import kr.loner.starcarftpoll.view.navi.GoToAction
import kr.loner.starcarftpoll.view.viewbase.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

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

            GoToAction.gotoStart(root)
        }
        buttonGuide.setOnClickListener {

            GoToAction.gotoGuide(root)
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