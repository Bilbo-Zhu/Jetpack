package com.jaca.jetpacktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jaca.jetpacktest.presenter.MainPresenter

class MainActivity : AppCompatActivity() {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainPresenter()
        lifecycle.addObserver(mainPresenter)
    }
}