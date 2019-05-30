package com.vitorota.todo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vitorota.todo.R
import com.vitorota.todo.Todo
import kotlinx.android.synthetic.main.item_todo.view.*

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
class TodoAdapter : ListAdapter<Todo, TodoAdapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = getItem(position)
        with(holder.itemView) {
            tvId.text = "${todo.id}"
            tvTitle.text = todo.title
            cbCompleted.isChecked = todo.completed
            container.setOnClickListener { cbCompleted.performClick() }
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    object DIFF_CALLBACK : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean = oldItem == newItem
    }
}