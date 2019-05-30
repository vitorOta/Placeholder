package com.vitorota.albums.data.local

import com.vitorota.albums.Album
import com.vitorota.albums.data.AlbumRepository
import com.vitorota.common.extensions.toBean

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class AlbumLocalRepository(private val dao: AlbumDao) : AlbumRepository<AlbumEntity> {
    override fun fromBean(album: Album) =
        AlbumEntity(
            userId = album.userId,
            id = album.id,
            title = album.title
        )

    override suspend fun list(): List<Album> {
        return dao.list().toBean()
    }

    suspend fun insert(albums: List<Album>) {
        dao.insert(albums.map { fromBean(it) })
    }
}