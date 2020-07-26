package com.example.starcarftpoll.view.viewbase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB: ViewDataBinding>(@LayoutRes private val layoutId:Int): Fragment() {

    lateinit var binding:VDB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<VDB>(inflater,layoutId,container,false).run{
        binding = this
        setOnCreateView()

        root
    }

    protected abstract fun VDB.setOnCreateView()
}