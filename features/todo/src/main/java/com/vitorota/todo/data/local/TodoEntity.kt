package com.vitorota.todo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vitorota.common.ToBean
import com.vitorota.todo.Todo

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */
@Entity
data class TodoEntity(
    val userId: Int,
    @PrimaryKey
    val id: Int,
    val title: String,
    val completed: Boolean
) : ToBean<Todo> {

    override fun toBean() =
        Todo(
            userId = userId,
            id = id,
            title = title,
            completed = completed
        )
}