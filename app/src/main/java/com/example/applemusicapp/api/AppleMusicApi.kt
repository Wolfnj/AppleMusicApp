package com.example.applemusicapp.api

import retrofit2.Call
import retrofit2.http.GET

interface AppleMusicApi {
    @GET("api/v1/us/apple-music/coming-soon/all/25/explicit.json")
    fun fetchAlbums(): Call<AppleMusicResponse>
}