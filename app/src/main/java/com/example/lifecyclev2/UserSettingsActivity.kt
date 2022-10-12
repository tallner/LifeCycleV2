package com.example.lifecyclev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_settings)

        val bottomNav: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.settings

        var name = findViewById<TextView>(R.id.name_input)

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {

                    var it = Intent(this, MainActivity::class.java)
                    startActivity(it)

                    true
                }

                R.id.settings -> {

                    true
                }

                R.id.user -> {
                    var it = Intent(this, UserDataActivity::class.java)
                    it.putExtra("EXTRA_NAME",name.text.toString())
                    startActivity(it)
                    true
                }

                else ->
                    true
            }

        }

    }
}