package kr.loner.starcarftpoll.view

import android.graphics.Color
import android.graphics.Typeface
import android.widget.RadioButton
import kr.loner.starcarftpoll.R
import kr.loner.starcarftpoll.databinding.FragmentGameBinding
import kr.loner.starcarftpoll.db.Question

object GameQuestionView {

    fun setQuestion(question: Question, binding: FragmentGameBinding) {
        binding.apply {
            textViewCurrent.text = question.current
            textViewPaper.text = question.paper

            radioButton1.text = question.option[0]
            radioButton2.text = question.option[1]
            radioButton3.text = question.option[2]
            radioButton4.text = question.option[3]
        }



    }

    fun textColorChange(radioButton: RadioButton, radioSelectColor: String) {
        radioButton.setTextColor(Color.parseColor(radioSelectColor))
        radioButton.setTypeface(null, Typeface.BOLD_ITALIC)
    }

    fun imageChange(currentQustion:Int):Int =

        when(currentQustion) {
            in 0..5 -> R.drawable.game7
            in 6..11 -> R.drawable.game3
            in 12..16 -> R.drawable.game2
            in 17..22 -> R.drawable.game4
            in 23..27 -> R.drawable.game5
            in 28..32 -> R.drawable.game8
            in 33..36 -> R.drawable.game6
            else -> 0
        }
    }
