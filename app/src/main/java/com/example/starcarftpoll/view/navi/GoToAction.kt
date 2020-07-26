package com.example.starcarftpoll.view.navi

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController

import com.example.starcarftpoll.R
import com.example.starcarftpoll.view.fragment.GameFragmentDirections

class GoToAction {
    fun gotoResult(view: View, score: Int) {
      findNavController(view)
            .navigate(
                GameFragmentDirections.actionGameFragmentToResultFragment(
                    result = score
                )
            )
    }

    fun gotoGame(view: View ) {
        findNavController(view).navigate(R.id.action_guideFragment_to_gameFragment)
    }

    fun gotoStart(view: View) {
        findNavController(view).navigate(R.id.action_mainFragment_to_gameFragment)
    }

    fun gotoGuide(view: View) {
        findNavController(view).navigate(R.id.action_mainFragment_to_guideFragment)
    }

    fun gotomain(view: View) {
        findNavController(view).navigate(R.id.action_splashFragment_to_mainFragment)
    }

}