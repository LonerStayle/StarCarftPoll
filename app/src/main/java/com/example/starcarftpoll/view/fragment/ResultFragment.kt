package com.example.starcarftpoll.view.fragment

import android.content.Intent
import android.graphics.drawable.*
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.starcarftpoll.R
import com.facebook.share.model.ShareLinkContent
import com.facebook.share.widget.ShareDialog
import kotlinx.android.synthetic.main.fragment_result.view.*

open class ResultFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_result, container, false)
        val args =
            ResultFragmentArgs.fromBundle(
                requireArguments()
            )

        val content = ShareLinkContent.Builder()
            .setContentUrl(Uri.parse("https://www.facebook.com"))
            .build()

        // 애니메이션
        val resultAnimation = root.imageView_Result.drawable as AnimationDrawable
            resultAnimation.start()

        // 등급 결과
        /**if (!isResumed) ?? 효과가 있는가. 폰트 변화시 튕기는 문제를 isResumed로 해결하긴 함*/
        Handler().postDelayed({
            root.imageView_Result.setImageResource(resultCalculator(args.result))
        },3000)



        //페이스북 공유
        root.imageButton_facebook.setOnClickListener {
            val shareDialog = ShareDialog(this)
            shareDialog.show(content, ShareDialog.Mode.FEED)
        }

        //카카오톡 공유
        root.imageButton_kakaoTalk.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain" // 고정 text

            sharingIntent.putExtra(Intent.EXTRA_TEXT, "hello~ shareText here")
            sharingIntent.setPackage("com.kakao.talk") // 고정 text

            startActivity(sharingIntent)
        }

        return root
    }


    //int가 반환형인데 반환형이 없을까봐 else 를 넣음
    fun resultCalculator(result: Int): Int = when (result) {
        in 57..70 -> R.drawable.result_s
        in 45..56 -> R.drawable.result_a
        in 30..44 -> R.drawable.result_b
        in 18..29 -> R.drawable.result_c
        in 10..17 -> R.drawable.result_d
        in 0..9 -> R.drawable.result_e
        else -> 0
    }
}


