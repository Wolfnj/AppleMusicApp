package com.example.applemusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appleMusicLiveData: LiveData<List<AlbumItem>> = AppleMusicFetcher().fetchAlbums()
        appleMusicLiveData.observe(
            this,
            Observer { albumItems ->
                Log.d(TAG,"Response received: $albumItems")
            }

        )


    }
}