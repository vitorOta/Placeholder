package com.vitorota.todo.data.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */
interface TodoApi {
    @GET("todo")
    fun list(): Deferred<List<TodoSchema>>
}