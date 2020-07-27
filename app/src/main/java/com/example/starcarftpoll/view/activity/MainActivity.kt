package com.example.starcarftpoll.view.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.starcarftpoll.R
import com.example.starcarftpoll.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

    }

}