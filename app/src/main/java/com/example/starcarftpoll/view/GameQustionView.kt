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

object GameQustionView {

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

    fun textColerChange(radioButton: RadioButton, radioSelectColor: String) {
        radioButton.setTextColor(Color.parseColor(radioSelectColor))
        radioButton.setTypeface(null, Typeface.BOLD_ITALIC)
    }

    fun imageChange(currentQustion:Int):Int =

        when(currentQustion) {
            in 0..10 -> R.drawable.game7
            in 11..20 -> R.drawable.game3
            in 21..30 -> R.drawable.game2
            in 31..40 -> R.drawable.game4
            in 41..50 -> R.drawable.game5
            in 51..60 -> R.drawable.game8
            in 61..70 -> R.drawable.game6
            else -> 0
        }
    }
