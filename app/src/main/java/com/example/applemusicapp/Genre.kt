package com.example.applemusicapp

import java.io.Serializable

data class Genre(
    var genreId: String = "",
    var name: String = "",
    var url: String = "",
) : Serializable
