package com.example.lifecyclev2

import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.TextView
import java.io.Serializable

data class User(

    val name: String,
    val age: String,
    var rating: String,
    var favdish: String,
    var animals: String

):Serializable