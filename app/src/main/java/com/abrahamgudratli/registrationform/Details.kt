package com.abrahamgudratli.registrationform

import java.io.Serializable

data class Details(
    var firstName: String,
    var lastName: String,
    var email: String,
    var phone: String,
    var password: String,
    var gender: String
): Serializable {

    fun getFullName(): String {
        return if (gender == "Male") {
            "Mr. $firstName $lastName"
        } else if (gender == "Female") {
            "Ms. $firstName $lastName"
        } else {
            "$firstName $lastName"
        }
    }

}
