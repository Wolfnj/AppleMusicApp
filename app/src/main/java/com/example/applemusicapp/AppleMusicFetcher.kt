package com.example.applemusicapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.applemusicapp.api.AppleMusicApi
import com.example.applemusicapp.api.AppleMusicResponse
import com.example.applemusicapp.api.ResultsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "AppleMusicFetcher"

class AppleMusicFetcher {

    private val appleMusicApi: AppleMusicApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://rss.itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        appleMusicApi = retrofit.create(AppleMusicApi::class.java)
    }

    fun fetchAlbums():LiveData<List<AlbumItem>>{
        val responseLiveData: MutableLiveData<List<AlbumItem>> = MutableLiveData()
        val appleMusicRequest: Call<AppleMusicResponse> = appleMusicApi.fetchAlbums()


        appleMusicRequest.enqueue(object : Callback<AppleMusicResponse>{
            override fun onResponse(call: Call<AppleMusicResponse>, response: Response<AppleMusicResponse>
            ) {
                Log.d(TAG, "Response received")
                val appleMusicResponse: AppleMusicResponse? = response.body()
                val resultsResponse: ResultsResponse? = appleMusicResponse?.albums
                var albumItems: List<AlbumItem> = resultsResponse?.albumItems
                    ?: mutableListOf()
                albumItems = albumItems.filterNot {
                    it.url.isBlank()
                }
                responseLiveData.value = albumItems

            }

            override fun onFailure(call: Call<AppleMusicResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch albums", t)
            }


        })



        return responseLiveData
    }


}