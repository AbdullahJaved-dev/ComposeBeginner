package com.example.composebeginner

import android.util.Patterns

fun String.isValidEmail(): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(this).matches()
}