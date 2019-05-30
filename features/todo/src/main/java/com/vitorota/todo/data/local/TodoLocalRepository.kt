package com.vitorota.todo.data.local

import com.vitorota.common.extensions.toBean
import com.vitorota.todo.Todo
import com.vitorota.todo.data.TodoRepository

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
class TodoLocalRepository(private val dao: TodoDao) : TodoRepository<TodoEntity> {
    override fun fromBean(todo: Todo): TodoEntity =
        TodoEntity(
            userId = todo.userId,
            id = todo.id,
            title = todo.title,
            completed = todo.completed
        )

    override suspend fun list(): List<Todo> {
        return dao.list().toBean()
    }

    suspend fun insert(data: List<Todo>) {
        dao.insert(data.map { fromBean(it) })
    }
}