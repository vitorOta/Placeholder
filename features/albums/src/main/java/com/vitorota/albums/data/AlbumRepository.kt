package com.vitorota.albums.data

import com.vitorota.albums.Album
import com.vitorota.common.ListRepository
import com.vitorota.common.ToBean

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
interface AlbumRepository<Type : ToBean<Album>> : ListRepository<Album> {
    fun fromBean(album: Album): Type
}