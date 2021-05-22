package com.example.applemusicapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class AlbumAdapter(private val albumItemsList: List<AlbumItem>,
                   private val listener: OnAlbumClickListener) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>()  {

    private val TAG = "AlbumAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.album_item,parent,
            false)
        return AlbumViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val currentAlbum =albumItemsList[position]

        holder.albumNameTextView.text = currentAlbum.name
        holder.artistNameTextView.text = currentAlbum.artistName
        Picasso.get().load(currentAlbum.artworkUrl100).into(holder.albumImageView)




    }

    override fun getItemCount(): Int {
        return albumItemsList.size
    }


    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        val albumNameTextView: TextView = itemView.findViewById(R.id.album_name_text_view)
        val albumImageView: ImageView = itemView.findViewById(R.id.album_image)
        val artistNameTextView: TextView = itemView.findViewById(R.id.artist_name_text_view)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    interface OnAlbumClickListener{
        fun onItemClick(position: Int)
    }

}