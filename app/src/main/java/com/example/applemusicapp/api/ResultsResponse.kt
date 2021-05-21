package com.example.applemusicapp.api

import com.example.applemusicapp.AlbumItem
import com.google.gson.annotations.SerializedName

/**
 * This class will map to the "results" object in the JSON data.
 */
class ResultsResponse {
    @SerializedName("results")
    lateinit var albumItems: List<AlbumItem>
}