package com.vitorota.albums.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vitorota.albums.Album
import com.vitorota.common.ToBean

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
@Entity
data class AlbumEntity(
    var userId: Int,
    @PrimaryKey
    var id: Int,
    var title: String
) : ToBean<Album> {
    override fun toBean() = Album(
        userId = userId,
        id = id,
        title = title
    )
}