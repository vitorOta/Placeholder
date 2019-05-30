package com.vitorota.albums.data.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
interface AlbumsApi {
    @GET("albums")
    fun list():Deferred<List<AlbumSchema>>
}