package com.vitorota.todo.data.network

import com.vitorota.common.ToBean
import com.vitorota.todo.Todo

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */

data class TodoSchema(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
) : ToBean<Todo> {
    override fun toBean() =
        Todo(
            userId = userId,
            id = id,
            title = title,
            completed = completed
        )

}