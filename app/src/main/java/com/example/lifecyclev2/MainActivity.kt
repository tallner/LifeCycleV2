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


class MainActivity : AppCompatActivity() {

    private lateinit var passwordEdit: EditText
    private lateinit var usernameEdit: EditText
    private lateinit var loginButton: Button

    private lateinit var sharedPreferences: SharedPreferences
    private var PREFS_KEY = "prefs"
    private var USER_KEY = "username"
    private var PWD_KEY = "password"

    private var username = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordEdit = findViewById(R.id.password_input)
        usernameEdit = findViewById(R.id.username_input)
        loginButton = findViewById(R.id.btn_login)
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

        username = sharedPreferences.getString(USER_KEY, "").toString()
        password = sharedPreferences.getString(PWD_KEY, "").toString()


        loginButton.setOnClickListener {
            if (TextUtils.isEmpty(usernameEdit.text.toString()) && TextUtils.isEmpty(passwordEdit.text.toString())) {
                Toast.makeText(this, "Please Enter Username and Password", Toast.LENGTH_SHORT).show();
            }
            else {
                // create variable for editor of shared prefs
                val editor: SharedPreferences.Editor = sharedPreferences.edit()

                // adding our username and pwd to shared prefs
                editor.putString(USER_KEY, usernameEdit.text.toString())
                editor.putString(PWD_KEY, passwordEdit.text.toString())

                // apply changes to our shared prefs.
                editor.apply()

                // if email and pwd is not empty we
                // are opening our main 2 activity on below line.
                val i = Intent(this, LoggedInActivity::class.java)

                // on below line we are calling start
                // activity method to start our activity.
                startActivity(i)

                // on below line we are calling
                // finish to finish our main activity.
                finish()

            }
        }
    }

    // on below line we are calling on start method.
    override fun onStart() {
        super.onStart()
        // in this method we are checking if email and pwd are not empty.
        if (!username.equals("") && !password.equals("")) {

            // if email and pwd is not empty we
            // are opening our main 2 activity on below line.
            val i = Intent(this, LoggedInActivity::class.java)

            // on below line we are calling start
            // activity method to start our activity.
            startActivity(i)

            // on below line we are calling
            // finish to finish our main activity.
            finish()
        }
    }


}