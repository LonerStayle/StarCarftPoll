package com.example.starcarftpoll.view

import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.widget.RadioButton
import androidx.databinding.ViewDataBinding
import com.example.starcarftpoll.R
import com.example.starcarftpoll.databinding.FragmentGameBinding
import com.example.starcarftpoll.db.Question
import kotlinx.android.synthetic.main.fragment_game.view.*

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
            in 0..1 -> R.drawable.game7
            in 2..3 -> R.drawable.game3
            in 4..5 -> R.drawable.game2
            in 6..7 -> R.drawable.game4
            in 8..9 -> R.drawable.game5
            10 -> R.drawable.game8
            11 -> R.drawable.game6
            else -> 0
        }
    }
