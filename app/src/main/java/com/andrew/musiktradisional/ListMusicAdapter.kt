package com.andrew.musiktradisional

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMusicAdapter(private val listMusic:ArrayList<Music>):RecyclerView.Adapter<ListMusicAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMusic.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val music = listMusic[position]

        Glide.with(holder.itemView.context)
            .load(music.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgMusic)

        holder.tvName.text = music.name
        holder.tvSource.text = music.source

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listMusic[holder.adapterPosition])
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_music_name)
        var tvSource: TextView = itemView.findViewById(R.id.tv_music_source)
        var imgMusic: ImageView = itemView.findViewById(R.id.img_music)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Music)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
}