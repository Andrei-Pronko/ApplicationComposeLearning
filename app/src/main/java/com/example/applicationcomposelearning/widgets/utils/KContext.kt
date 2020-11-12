package com.example.applicationcomposelearning.widgets.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.savedinstancestate.mapSaver
import androidx.compose.runtime.savedinstancestate.savedInstanceState

data class City(val name: String, val country: String)

val CitySaver = run {
    val nameKey = "Name"
    val countryKey = "Country"
    mapSaver(
        save = { mapOf(nameKey to it.name, nameKey to it.country) },
        restore = { City(it[nameKey] as String, it[countryKey] as String) }
    )
}

@Composable
fun MyExample() {
    var selectedCity = savedInstanceState(CitySaver) { City("Madrid", "Spain") }
}