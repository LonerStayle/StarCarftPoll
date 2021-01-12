package kr.loner.starcarftpoll.view.fragment

import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kr.loner.starcarftpoll.R
import kr.loner.starcarftpoll.databinding.FragmentSplashBinding
import kr.loner.starcarftpoll.view.navi.GoToAction
import kr.loner.starcarftpoll.view.viewbase.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.view.*


 class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val dp by lazy { resources.displayMetrics.density }


    override fun FragmentSplashBinding.setOnCreateView() {


        var clickCount = 0

        val moonAnimation = AnimationUtils.loadAnimation(
            context,
            R.anim.splash_textview_moon
        )

        textViewMoonClick.startAnimation(moonAnimation)

        imageButtonMoon.setOnClickListener {
            clickCount++
            if (clickCount == 1) {
                splashAnimation()
            }
        }
    }

    private fun splashAnimation() {

        binding.apply {

            textViewMoonClick.clearAnimation()
            textViewMoonClick.visibility = View.GONE
            imageButtonMoon.animate().translationY(-380f * dp).setDuration(800L)
                .setInterpolator(AccelerateDecelerateInterpolator())
                .withEndAction {
                    imageButtonMoon.setImageResource(R.drawable.splash_night_mode)
                    ImageViewCompat.setImageTintList(
                        imageButtonMoon,
                        ColorStateList.valueOf(0)
                    )
                    imageButtonMoon.animate().rotation(360f).setDuration(600L)
                        .withEndAction {
                            GoToAction.goToMain(root)
                        }.start()
                }.start()
        }

    }


}
