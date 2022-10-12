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


        findViewById<TextView>(R.id.name_output).text =
            "Your name is " + intent.getStringExtra("EXTRA_NAME") +
            " and you are " + intent.getStringExtra("EXTRA_AGE") + " years old."

        findViewById<TextView>(R.id.rating_output).text =
            "Your rate yourself to " + intent.getStringExtra("EXTRA_RATING") + " out of 5 stars."

        findViewById<TextView>(R.id.fav_output).text =
            "You love " + intent.getStringExtra("EXTRA_DISH") + " and these animals: " +
            intent.getStringExtra("EXTRA_ANIMALS")


        val bottomNav: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.user

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    var i = Intent(this, MainActivity::class.java)
                    startActivity(i)

                    true
                }

                R.id.settings -> {
                    var i = Intent(this, UserSettingsActivity::class.java)
                    startActivity(i)
                    true
                }

                R.id.user -> {

                    true
                }

                else ->
                    true
            }

        }
    }
}