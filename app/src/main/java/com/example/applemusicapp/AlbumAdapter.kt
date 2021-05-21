package com.example.applemusicapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



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

        holder.titleTextView.text = currentAlbum.name
        Log.d(TAG,"Album Name ${position}: ${currentAlbum.name}")



    }

    override fun getItemCount(): Int {
        return albumItemsList.size
    }


    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)

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