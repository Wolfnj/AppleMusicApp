package com.example.applemusicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemusicapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AlbumAdapter.OnAlbumClickListener {

    private val TAG = "MainActivity"


    //lateinit var albumAdapter: AlbumAdapter;

    companion object {
        const val REQUEST_ALBUM_CLICK = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val albumRecyclerView: RecyclerView = binding.albumsRecyclerView
        val appleMusicLiveData: LiveData<List<AlbumItem>> = AppleMusicFetcher().fetchAlbums()
        appleMusicLiveData.observe(
            this,
            Observer { albumItems ->
                //Log.d(TAG,"Response received: $albumItems")
                Log.d(TAG,"albumItems Type: ${albumItems.javaClass.name}")
                val albumAdapter: AlbumAdapter = AlbumAdapter(albumItems,this)

                albumRecyclerView.adapter = albumAdapter
                albumRecyclerView.layoutManager = LinearLayoutManager(this)

                albumRecyclerView.setHasFixedSize(true)


            }

        )


    }











    override fun onItemClick(position: Int) {

    }








}