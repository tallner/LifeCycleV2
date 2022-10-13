package com.example.lifecyclev2

import java.io.Serializable

data class User(

    val name: String,
    val age: String,
    var rating: String,
    var favdish: String,
    var animals: String

):Serializable