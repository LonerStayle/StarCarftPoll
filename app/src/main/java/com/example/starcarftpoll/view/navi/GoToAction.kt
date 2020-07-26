package com.example.starcarftpoll.view.navi

import android.view.View
import androidx.navigation.findNavController

import com.example.starcarftpoll.R
import com.example.starcarftpoll.view.fragment.GameFragmentDirections

class GoToAction {
    fun gotoResult(root: View, score: Int) {
        root.findNavController()
            .navigate(
                GameFragmentDirections.actionGameFragmentToResultFragment(
                    result = score
                )
            )
    }

    fun gotoGame(root: View ) {
        root.findNavController().navigate(R.id.action_guideFragment_to_gameFragment)
    }

    fun gotoStart(root: View) {
        root.findNavController().navigate(R.id.action_mainFragment_to_gameFragment)
    }

    fun gotoGuide(root: View) {
        root.findNavController().navigate(R.id.action_mainFragment_to_guideFragment)
    }

    fun gotomain(root: View) {
        root.findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
    }

}