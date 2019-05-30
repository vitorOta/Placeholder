package com.vitorota.albums.data.network

import com.vitorota.albums.Album
import com.vitorota.albums.data.AlbumRepository
import com.vitorota.common.extensions.toBean
import com.vitorota.common.utils.SynchronousRequestManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class AlbumCloudRepository(private val api: AlbumsApi) : AlbumRepository<AlbumSchema> {
    override fun fromBean(album: Album) =
        AlbumSchema(
            userId = album.userId,
            id = album.id,
            title = album.title
        )

    override suspend fun list(): List<Album> {
        return withContext(Dispatchers.IO) {
            SynchronousRequestManager<List<AlbumSchema>>().getResult(api.list())
                .toBean()
        }
    }
}