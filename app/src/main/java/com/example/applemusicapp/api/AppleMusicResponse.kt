package com.example.applemusicapp.api

import com.google.gson.annotations.SerializedName

/**
 * This class will map to the outermost object in the JSON data. With the Apple Music App,
 * this would map to the "feed" field.
 */
class AppleMusicResponse {
    @SerializedName("feed")
    lateinit var albums: ResultsResponse
}