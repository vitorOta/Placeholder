package com.vitorota.posts.data.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
interface PostsApi {
    @GET("posts")
    fun list(): Deferred<List<PostSchema>>
}