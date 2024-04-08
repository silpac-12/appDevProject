package com.example.appdevelopmentproject.data

data class User(val firstName: String,
                val lastName: String,
                val email: String,
                val imageString: String = ""){

    constructor():this("","","","")


}
