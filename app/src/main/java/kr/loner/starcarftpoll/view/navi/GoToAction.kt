package kr.loner.starcarftpoll.view.navi

import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController


import kr.loner.starcarftpoll.R
import kr.loner.starcarftpoll.view.fragment.GameFragmentDirections

class GoToAction {

    companion object{
        fun gotoResult(view: View, score: Int) {
            view.findNavController()
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

        fun goToMain(view: View) {
            findNavController(view).navigate(R.id.action_splashFragment_to_mainFragment)
        }
    }


}