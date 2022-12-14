package com.example.lifecyclev2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView


class LoggedInActivity : AppCompatActivity() {


    private lateinit var logoutButton: Button
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var userTV: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private var PREFS_KEY = "prefs"
    private var USER_KEY = "username"
    private var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loggedin)

        logoutButton = findViewById(R.id.btn_logout)
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        bottomNav = findViewById(R.id.bottom_navigation)
        userTV = findViewById(R.id.tv_username)

        // on below line we are getting the data from
        // name and setting it in email variable.
        username = sharedPreferences.getString(USER_KEY, null)!!

        // on below line we are setting a text to user text view.
        userTV.text = "Welcome \n$username"

        Log.i("myLog", username)

        logoutButton.setOnClickListener {
            // on below line we are creating a variable for
            // editor of shared preferences and initializing it.
            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            // on below line we are clearing our editor.
            editor.clear()

            // on below line we are applying changes which are cleared.
            editor.apply()

            // on below line we are opening our mainactivity by calling intent
            val i = Intent(this, MainActivity::class.java)

            // on below line we are simply starting
            // our activity to start main activity
            startActivity(i)

            // on below line we are calling
            // finish to close our this activity
            finish()
        }

        bottomNav.selectedItemId = R.id.home
        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.settings -> {
                    var i = Intent(this, UserSettingsActivity::class.java)
                    startActivity(i)
                    finish()
                    true
                }
                R.id.user -> {
                    var i = Intent(this, UserDataActivity::class.java)
                    startActivity(i)
                    finish()
                    true
                }
                else ->
                    true
            }
        }
    }




}