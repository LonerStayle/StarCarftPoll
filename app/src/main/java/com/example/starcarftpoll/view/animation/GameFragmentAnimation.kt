package com.example.starcarftpoll.view.animation

import android.view.View
import android.view.animation.Animation
import android.widget.RadioButton
import com.example.starcarftpoll.view.fragment.GameFragment
import kotlinx.android.synthetic.main.fragment_game.view.*

class GameFragmentAnimation: GameFragment() {

    fun gameAnimation(root:View,imageAnimation:Animation,currentPaperAnimation: Animation,dp:Float) {
        //이미지 애니메이션
        root.imageView_GameBackground.startAnimation(imageAnimation)

        //애니메이션 뒤늦게
        root.textView_paper.startAnimation(currentPaperAnimation)
        root.textView_paper.visibility = View.VISIBLE

        //애니메이션 답지
        for (i in 1..4) {
            root.findViewById<RadioButton>(
                root.resources.getIdentifier(
                    "radioButton$i",
                    "id",
                    "com.example.starcarftpoll"
                )
            ).run {
                    animate().translationX(300f * dp).setDuration(10L).withEndAction {
                       animate().setStartDelay(5000L).translationX(0f).setDuration(1000L)
                            .withStartAction {
                                visibility = View.VISIBLE
                            }.start()
                    }.start()
                }
        }
    }
}