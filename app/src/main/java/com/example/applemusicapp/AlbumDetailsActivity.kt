package com.example.applemusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applemusicapp.databinding.ActivityAlbumDetailsBinding
import com.squareup.picasso.Picasso

class AlbumDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        val albumName = binding.albumNameTextView
        val artistName = binding.artistNameTextView
        val albumImage = binding.albumImage
        val albumGenre = binding.genreTextView
        val albumReleaseDate = binding.releaseDateTextView
        val albumCopyRight = binding.copyRateTextView
        val moreOnAlbum = binding.albumMoreTextView
        val moreOnArtist = binding.artistMoreTextView

        val intent = getIntent()
        val currentAlbumItem = intent.extras?.get("albumItem") as AlbumItem


        albumName.text = currentAlbumItem.name
        artistName.text = currentAlbumItem.artistName
        Picasso.get().load(currentAlbumItem.artworkUrl100).into(albumImage)
        albumReleaseDate.text = currentAlbumItem.releaseDate

        var genres: String ="";

        for (genre in currentAlbumItem.genres) {
            if(!genre.name.equals("Music")){
                genres += genre.name + ", "
            }
        }

        genres = genres.dropLast(2)

        albumGenre.text = genres


        albumCopyRight.text = currentAlbumItem.copyright
        moreOnAlbum.text = currentAlbumItem.url
        moreOnArtist.text = currentAlbumItem.artistUrl


    }
}