package com.example.lifecyclev2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private var loginStatus: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MyTag", this.lifecycle.currentState.toString())

        val bottomNav: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.home
        bottomNav.menu.forEach {
            it.isEnabled=loginStatus
            it.isVisible=loginStatus
        }

        val password: EditText = findViewById(R.id.password_input)
        val loginButton: Button = findViewById(R.id.btn_login)



        loginButton.setOnClickListener {
            loginStatus = password.text.toString().equals("pw")
            bottomNav.menu.forEach {
                it.isEnabled=loginStatus
                it.isVisible=loginStatus
            }
        }






        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {

                    true
                }

                R.id.settings -> {
                    var i = Intent(this, UserSettingsActivity::class.java)
                    startActivity(i)
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

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("MyTag", this.lifecycle.currentState.toString())
        outState.putBoolean("loginStatus", loginStatus)
        Log.i("MyTag", "onSaveInstanceState")
        Log.i("MyTag", loginStatus.toString())
        super.onSaveInstanceState(outState)

        Log.i("MyTag", this.lifecycle.currentState.toString())


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        loginStatus = savedInstanceState.getBoolean("loginStatus")
        Log.i("MyTag", "onRestoreInstanceState")
        Log.i("MyTag", loginStatus.toString())
    }


}