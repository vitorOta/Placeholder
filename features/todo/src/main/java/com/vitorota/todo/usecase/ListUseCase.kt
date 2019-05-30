package com.vitorota.todo.usecase

import com.vitorota.common.UseCase
import com.vitorota.common.exceptions.RepositoryException
import com.vitorota.todo.Todo
import com.vitorota.todo.data.local.TodoLocalRepository
import com.vitorota.todo.data.network.TodoCloudRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
class ListUseCase(
    private val cloudRepository: TodoCloudRepository,
    private val localRepository: TodoLocalRepository
) :
    UseCase<Unit?, List<Todo>> {
    override suspend fun execute(args: Unit?): List<Todo> {
        return withContext(Dispatchers.IO) {
            try {
                var data = localRepository.list()
                if (data.isNullOrEmpty()) {
                    data = cloudRepository.list()
                    localRepository.insert(data)
                }

                data
            } catch (e: RepositoryException) {
                //can be different, but for now will be this
                emptyList<Todo>()
            }
        }
    }
}