package kr.loner.starcarftpoll.view.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

import kr.loner.starcarftpoll.R
import kr.loner.starcarftpoll.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

    }

}