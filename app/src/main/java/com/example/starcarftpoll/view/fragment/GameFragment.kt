package com.example.starcarftpoll.view.fragment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.addCallback
import com.example.starcarftpoll.R
import com.example.starcarftpoll.databinding.FragmentGameBinding
import com.example.starcarftpoll.db.Question
import com.example.starcarftpoll.view.GameQustionView
import com.example.starcarftpoll.view.navi.GoToAction
import com.example.starcarftpoll.view.viewbase.BaseFragment



 class GameFragment : BaseFragment<FragmentGameBinding>(R.layout.fragment_game) {
    private val current by lazy { resources.getStringArray(R.array.currentQustion) }
    private val currentPaper by lazy { resources.getStringArray(R.array.currentPaper) }
    private val option1 by lazy { resources.getStringArray(R.array.option1) }
    private val option2 by lazy { resources.getStringArray(R.array.option2) }
    private val option3 by lazy { resources.getStringArray(R.array.option3) }
    private val option4 by lazy { resources.getStringArray(R.array.option4) }
    private val answer by lazy { resources.getIntArray(R.array.answer) }
    private val questionNumber by lazy { questions!!.size }
   //늦은 var 초기화 latelnit var는 사실상 자바사용자를 위한 것
    private var questions: List<Question>? = null
    private var currentQuestion = 0
    private var gamescore = 0
    private val radioSelectColor = "#02F6E4"
    private val imageAnimation by lazy { AnimationUtils.loadAnimation(context,
        R.anim.game_image_animation
    ) }
    private val white by lazy { "#FFFFFF" }
    private val currentPaperAnimation by lazy { AnimationUtils.loadAnimation(context,
        R.anim.game_currntpaper_animation
    ) }
 private val dp by lazy { resources.displayMetrics.density }

    override fun FragmentGameBinding.setOnCreateView() {

        // 애니메이션 시작
        gameAnimation()

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
        GameQustionView.setQuestion(question,this)


        radio.setOnCheckedChangeListener { group, checkedId ->

            if (currentQuestion < questionNumber) {
                imageViewGameBackground.setImageResource(
                    GameQustionView.imageChange(
                        currentQuestion
                    )
                )
                val questionAnswer = questions!![currentQuestion].answer

                when (checkedId) {

                    R.id.radioButton1 -> {
                        GameQustionView.textColerChange(radioButton1, radioSelectColor)
                        if (questionAnswer == 1) {
                            gamescore++
                        } else if (currentQuestion ==-1) {
                            gamescore--
                        }
                    }
                    R.id.radioButton2 -> {
                        GameQustionView.textColerChange(radioButton2, radioSelectColor)
                        if (questionAnswer == 2)
                            gamescore++
                        else if (currentQuestion == -1) {
                            gamescore--
                        }

                    }
                    // 2020-05-14 문제 가능성 발견 아직모름
                    R.id.radioButton3 -> {
                        GameQustionView.textColerChange(radioButton3, radioSelectColor)
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
                        GameQustionView.textColerChange(radioButton4, radioSelectColor)
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
                        GameQustionView.setQuestion(nextQuestion,this )
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
                    GoToAction.gotoResult(root,gamescore)
                }


                // 네비게이션 백 프레스 버튼 뒤로가기 설정
                requireActivity().onBackPressedDispatcher.addCallback(this@GameFragment) {
                    val prevQuestion = questions!![--currentQuestion]
                    GameQustionView.setQuestion(prevQuestion,binding )
                }
            }

        }
    }
    private fun gameAnimation() {
         binding.apply {

             //이미지 애니메이션
             imageViewGameBackground.startAnimation(imageAnimation)

             //애니메이션 뒤늦게
             textViewPaper.startAnimation(currentPaperAnimation)
             textViewPaper.visibility = View.VISIBLE

             //애니메이션 답지
             for (i in 1..4) {
                 root.findViewById<RadioButton>(
                     resources.getIdentifier(
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

}



