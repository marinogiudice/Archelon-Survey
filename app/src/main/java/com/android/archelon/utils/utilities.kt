package com.android.archelon.utils

import java.util.regex.Matcher
import java.util.regex.Pattern


fun validateEmail(email: String ) : Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun validatePassword(pass: String) : Boolean {
    val pattern: Pattern = Pattern.compile("[a-zA-Z0-9]{1,25}")
    val matcher: Matcher = pattern.matcher(pass)
    return matcher.matches()

}

