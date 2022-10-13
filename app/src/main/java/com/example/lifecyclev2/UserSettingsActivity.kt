package com.example.lifecyclev2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_settings)

        var user: User? = User("","","","","")
        val btnSubmit :Button = findViewById(R.id.btn_submit)
        val bottomNav: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.settings

        var name = findViewById<TextView>(R.id.name_input)
        var age = findViewById<TextView>(R.id.age_input)
        var rating = findViewById<RatingBar>(R.id.life_rating)
        var favdish = findViewById<RadioGroup>(R.id.dish)
        var cat = findViewById<CheckBox>(R.id.checkBox_cat)
        var dog = findViewById<CheckBox>(R.id.checkBox_dog)
        var horse = findViewById<CheckBox>(R.id.checkBox_horse)
        var bird = findViewById<CheckBox>(R.id.checkBox_bird)

        btnSubmit.setOnClickListener {

            var selectedRadioButton = findViewById<RadioButton>(favdish.checkedRadioButtonId)
            var animals : String  = ""

            if (cat.isChecked) animals += "cat"
            if (dog.isChecked) animals += " dog"
            if (horse.isChecked) animals += " horse"
            if (bird.isChecked) animals += " bird"

            user = User(
                name.text.toString(),
                age.text.toString(),
                rating?.rating.toString(),
                selectedRadioButton?.text.toString(),
                animals)

            Log.i("settings", user.toString())
        }

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    var it = Intent(this, MainActivity::class.java)
                    startActivity(it)
                    true
                }

                R.id.user -> {
                    var it = Intent(this, UserDataActivity::class.java)
                    it.putExtra("EXTRA_USER",user)
                    startActivity(it)
                    true
                }
                else ->
                    true
            }
        }
    }
}