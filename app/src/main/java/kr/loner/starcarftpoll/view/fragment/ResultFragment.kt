package kr.loner.starcarftpoll.view.fragment

import android.content.Intent
import android.graphics.drawable.*
import android.net.Uri
import android.os.Handler
import android.widget.Toast
import com.facebook.share.model.*
import com.facebook.share.widget.ShareDialog
import kotlinx.android.synthetic.main.fragment_result.view.*
import kr.loner.starcarftpoll.R
import kr.loner.starcarftpoll.databinding.FragmentResultBinding
import kr.loner.starcarftpoll.view.viewbase.BaseFragment

open class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {

    private val args by lazy {
        ResultFragmentArgs.fromBundle(
            requireArguments()
        )
    }
    private var resultImage: String? = null
    override fun FragmentResultBinding.setOnCreateView() {


        // 애니메이션
        val resultAnimation = imageViewResult.drawable as AnimationDrawable
        resultAnimation.start()

        // 등급 결과
        Handler().postDelayed({
            resultImage =
                "android.resource://${requireActivity().packageName}/drawable/${resultCalculator(args.result)}"
            root.imageView_Result.setImageURI(Uri.parse(resultImage))
        }, 3000)

        "android.resource://${requireActivity().packageName}/"
        //페이스북 공유
        imageButtonFacebook.setOnClickListener {

            val content = ShareLinkContent.Builder()
                    /**내앱링크로 변경할것 변경 예정  */
                .setContentUrl(Uri.parse("https://www.facebook.com"))
                .build()
//            val image = SharePhoto.Builder()
//                .setImageUrl(Uri.parse(resultImage))
//                .build()
//            SharePhotoContent.Builder().also {
//                it.addPhoto(image)
//                it.build()
//            }
            ShareDialog(this@ResultFragment).show(content, ShareDialog.Mode.AUTOMATIC)

            }




        //카카오톡 공유
        imageButtonKakaoTalk.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain" // 고정 text

            sharingIntent.putExtra(Intent.EXTRA_TEXT, "hello~ shareText here")
            sharingIntent.setPackage("com.kakao.talk") // 고정 text
            try {
                startActivity(sharingIntent)
            }catch (e:Exception){
                Toast.makeText(requireContext(), "카카오톡 앱이 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }


    //int가 반환형인데 반환형이 없을까봐 else 를 넣음
    private fun resultCalculator(result: Int): String = when (result) {
        in 31..36 -> "result_s"
        in 25..30 -> "result_a"
        in 18..24 -> "result_b"
        in 13..18 -> "result_c"
        in 7..12 -> "result_d"
        in 0..6 -> "result_e"
        else -> ""
    }

}


