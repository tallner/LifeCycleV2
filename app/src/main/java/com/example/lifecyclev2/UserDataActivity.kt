package com.example.lifecyclev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        val user = intent.getSerializableExtra("EXTRA_USER") as User
        findViewById<TextView>(R.id.name_output).text = user.toString()

        val bottomNav: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.user

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    var i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    finish()
                    true
                }

                R.id.settings -> {
                    var i = Intent(this, UserSettingsActivity::class.java)
                    startActivity(i)
                    finish()
                    true
                }
                else -> true
            }

        }
    }
}