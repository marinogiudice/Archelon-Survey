package com.android.archelon.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * This file contains helper methods to validate the
 * Username (email) and password format
 * inserted by the user in the login screen
 * I used google android developer website as pointer:
 * https://developer.android.com/reference/java/util/regex/Pattern
 */

/*
    takes a string as parameter
    returns a boolean.
    Uses the Pattern class java.util.regex
    to check if the parameter string email contains a valid email address
 */

fun validateEmail(email: String ) : Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

/*
    takes a string as parameter
    returns boolean
    create a new Pattern object to define the valid character's set
    check if the String pass parameter is validby the matcher object
 */
fun validatePassword(pass: String) : Boolean {
    val pattern: Pattern = Pattern.compile("[a-zA-Z0-9]{1,25}")
    val matcher: Matcher = pattern.matcher(pass)
    return matcher.matches()

}

