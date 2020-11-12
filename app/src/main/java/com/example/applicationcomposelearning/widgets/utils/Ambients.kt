package com.example.applicationcomposelearning.widgets.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.ambientOf
import androidx.compose.ui.platform.ContextAmbient

data class User(val name: String, val age: Int)

val ActiveUser = ambientOf<User> { error("No user found!") }

@Composable
fun Test1() {
    val user = User("Tom", 29)
    Providers(ActiveUser provides user) {
        Test2()
    }
    ContextAmbient
}

@Composable
fun Test2() {
    val user = ActiveUser.current
}

