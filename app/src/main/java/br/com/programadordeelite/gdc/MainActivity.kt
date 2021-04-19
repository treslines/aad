package br.com.programadordeelite.gdc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/** Single Page Activity - Entry Point */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

//class MainActivity : AppCompatActivity(R.layout.activity_main)