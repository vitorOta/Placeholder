package com.vitorota.albums.data.network

import com.vitorota.albums.Album
import com.vitorota.common.ToBean

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
data class AlbumSchema(
    var userId: Int,
    var id: Int,
    var title: String
) : ToBean<Album> {
    override fun toBean() = Album(
        userId = userId,
        id = id,
        title = title
    )
}