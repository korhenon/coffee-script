package com.example.coffeescript.data.models

data class Address(
    val address: String = "",
    val city: String = "",
    val coordinates: Coordinates = Coordinates(),
    val postalCode: String = "",
    val state: String = ""
)