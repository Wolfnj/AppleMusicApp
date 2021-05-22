package com.example.applemusicapp

import java.io.Serializable

data class AlbumItem(
        var artistName: String = "",
        var id: String = "",
        var releaseDate: String = "",
        var name: String = "",
        var kind: String = "",
        var copyright: String = "",
        var artistId: String = "",
        var contentAdvisoryRating: String = "",
        var artistUrl: String = "",
        var artworkUrl100: String = "",
        var genres: List<Genre> = emptyList(),
        var url: String = "",
        ) : Serializable
