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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView


class LoggedInActivity : AppCompatActivity() {


    private lateinit var loginButton: Button
    private lateinit var bottomNav: BottomNavigationView

    private lateinit var sharedPreferences: SharedPreferences
    private var PREFS_KEY = "prefs"
    private var USER_KEY = "username"
    private var PWD_KEY = "password"

    private var username = ""
    private var password = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loggedin)

        loginButton = findViewById(R.id.btn_login)
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        bottomNav = findViewById(R.id.bottom_navigation)

        username = sharedPreferences.getString(USER_KEY, "").toString()
        password = sharedPreferences.getString(PWD_KEY, "").toString()

        bottomNav.menu.forEach {
            it.isEnabled=false
            it.isVisible=false
        }

        loginButton.setOnClickListener {

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

    // on below line we are calling on start method.
    override fun onStart() {
        super.onStart()
        // in this method we are checking if email and pwd are not empty.
        if (!username.equals("") && !password.equals("")) {
            bottomNav.menu.forEach {
                it.isEnabled=true
                it.isVisible=true
            }
            // if email and pwd is not empty we
            // are opening our main 2 activity on below line.
           // val i = Intent(this, UserSettingsActivity::class.java)

            // on below line we are calling start
            // activity method to start our activity.
           // startActivity(i)

            // on below line we are calling
            // finish to finish our main activity.
          //  finish()
        }
    }


}