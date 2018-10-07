package com.meier.marina.remembrall.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.meier.marina.remembrall.R

class HomeActivity : AppCompatActivity() {

    private lateinit var navigator: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onSupportNavigateUp() = navigator.navigateUp()
}
