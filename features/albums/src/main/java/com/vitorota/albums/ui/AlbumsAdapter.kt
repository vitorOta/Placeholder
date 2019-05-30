package com.vitorota.albums.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vitorota.albums.Album
import com.vitorota.albums.R
import kotlinx.android.synthetic.main.item_album.view.*

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class AlbumsAdapter : ListAdapter<Album, AlbumsAdapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posts = getItem(position)
        with(holder.itemView) {
            tvTitle.text = posts.title
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    object DIFF_CALLBACK : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean = oldItem == newItem
    }
}