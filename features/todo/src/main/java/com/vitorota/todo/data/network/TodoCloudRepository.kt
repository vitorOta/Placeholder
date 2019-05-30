package com.vitorota.todo.data.network

import com.vitorota.common.ListRepository
import com.vitorota.common.extensions.toBean
import com.vitorota.common.utils.SynchronousRequestManager
import com.vitorota.todo.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
class TodoCloudRepository(private val api: TodoApi) : ListRepository<Todo> {
    override suspend fun list(): List<Todo> {
        return withContext(Dispatchers.IO) {
            val list = SynchronousRequestManager<List<TodoSchema>>().getResult(api.list())
            list.toBean()
        }
    }
}