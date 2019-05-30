package com.vitorota.todo.data

import com.vitorota.common.ListRepository
import com.vitorota.common.ToBean
import com.vitorota.todo.Todo

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
interface TodoRepository<Type : ToBean<Todo>> : ListRepository<Todo> {
    fun fromBean(todo: Todo): Type
}