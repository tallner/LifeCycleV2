package com.example.lifecyclev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_settings)
        val bottomNav: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.home

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    var i = Intent(this, MainActivity::class.java)
                    startActivity(i)

                    true
                }

                R.id.settings -> {

                    true
                }

                R.id.user -> {
                    var i = Intent(this, UserDataActivity::class.java)
                    startActivity(i)
                    true
                }

                else ->
                    true
            }

        }

    }
}