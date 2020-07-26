package com.example.starcarftpoll.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_game.view.*
import android.graphics.Typeface
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.addCallback
import com.example.starcarftpoll.R
import com.example.starcarftpoll.db.Question
import com.example.starcarftpoll.view.Game_QustionView
import com.example.starcarftpoll.view.navi.GoToAction
import com.example.starcarftpoll.view.animation.GameFragmentAnimation
import kotlinx.android.synthetic.main.fragment_game.*

val goToAction = GoToAction()


open class GameFragment : Fragment() {
    val current by lazy { resources.getStringArray(R.array.currentQustion) }
    val currentPaper by lazy { resources.getStringArray(R.array.currentPaper) }
    val option1 by lazy { resources.getStringArray(R.array.option1) }
    val option2 by lazy { resources.getStringArray(R.array.option2) }
    val option3 by lazy { resources.getStringArray(R.array.option3) }
    val option4 by lazy { resources.getStringArray(R.array.option4) }
    val answer by lazy { resources.getIntArray(R.array.answer) }
    val questionNumber by lazy { questions!!.size }
    //늦은 var 초기화 latelnit var는 사실상 자바사용자를 위한 것
    var questions: List<Question>? = null
    var currentQuestion = 0
    var gamescore = 0

    val radioSelectColor = "#02F6E4"
    val imageAnimation by lazy { AnimationUtils.loadAnimation(context,
        R.anim.game_image_animation
    ) }
    val white by lazy { "#FFFFFF" }
    val currentPaperAnimation by lazy { AnimationUtils.loadAnimation(context,
        R.anim.game_currntpaper_animation
    ) }
    val dp by lazy { resources.displayMetrics.density }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_game, container, false)

        val gameAnimation =
            GameFragmentAnimation()

        // 애니메이션 시작
        gameAnimation.gameAnimation(root, imageAnimation, currentPaperAnimation, dp)

        //문제번호, 문제 설명, 답안 선택지, 문제의 답 모두 넣기
        questions = List<Question>(3) { index ->
            Question(
                "",
                "",
                listOf(),
                0
            )
        }
        for (i in questions!!.indices) {
            questions!![i].current += current[i]
            questions!![i].paper += currentPaper[i]
            questions!![i].option += option1[i]
            questions!![i].option += option2[i]
            questions!![i].option += option3[i]
            questions!![i].option += option4[i]
            questions!![i].answer += answer[i]
        }

        // 현재 문제 번호를 넣을 값
        val question = questions!![currentQuestion]
        // View
        Game_QustionView.setQuestion(question, root)


        root.radio.setOnCheckedChangeListener { group, checkedId ->

            if (currentQuestion < questionNumber) {
                root.imageView_GameBackground.setImageResource(
                    Game_QustionView.imageChange(
                        currentQuestion
                    )
                )
                val questionAnswer = questions!![currentQuestion].answer

                when (checkedId) {

                    R.id.radioButton1 -> {
                        Game_QustionView.textColerChange(radioButton1, radioSelectColor)
                        if (questionAnswer == 1) {
                            gamescore++
                        } else if (currentQuestion ==-1) {
                            gamescore--
                        }
                    }
                    R.id.radioButton2 -> {
                        Game_QustionView.textColerChange(radioButton2, radioSelectColor)
                        if (questionAnswer == 2)
                            gamescore++
                        else if (currentQuestion == -1) {
                            gamescore--
                        }

                    }
                    // 2020-05-14 문제 가능성 발견 아직모름
                    R.id.radioButton3 -> {
                        Game_QustionView.textColerChange(radioButton3, radioSelectColor)
                        if (questionAnswer == 3) {
                            gamescore++
                            if (currentQuestion == 2) {
                                gamescore += 10
                            } else if (currentQuestion == -1) {
                                gamescore -= 10
                            } else {
                                gamescore--
                            }
                        }
                    }
                    R.id.radioButton4 -> {
                        Game_QustionView.textColerChange(radioButton4, radioSelectColor)
                        if (questionAnswer == 4)
                            gamescore++ else if (currentQuestion == -1) {
                            gamescore--
                        }
                    }

                    else -> return@setOnCheckedChangeListener
                }

                // 다음 문제로 넘어가기
                if (currentQuestion + 1 < questionNumber) {
                    val nextQuestion = questions!![++currentQuestion]
                    // 아주 잠깐의 선택 답 폰트, 색 변화
                    Handler().postDelayed({
                        for (i in 1..4) {
                            root.findViewById<RadioButton>(checkedId).run {
                                setTextColor(Color.parseColor(white))
                                setTypeface(null, Typeface.BOLD)
                            }
                        }
                        Game_QustionView.setQuestion(nextQuestion, root)
                    }, 300)
                    group.clearCheck()

                    //마지막 문제
                    if (currentQuestion == questionNumber - 1) {
                        Handler().postDelayed({
                            if (isResumed)
                                Toast.makeText(context, "마지막 문제입니다.", Toast.LENGTH_SHORT).show()
                        }, 300)
                    }
                } else {
                    goToAction.gotoResult(root, gamescore)
                }


             // 네비게이션 백 프레스 버튼 뒤로가기 설정
                requireActivity().onBackPressedDispatcher.addCallback(this) {
                    val prevQuestion = questions!![--currentQuestion]
                    Game_QustionView.setQuestion(prevQuestion, root)
                }
            }

        }
        return root
    }

}



