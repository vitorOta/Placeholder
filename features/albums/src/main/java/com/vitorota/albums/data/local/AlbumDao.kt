package com.vitorota.albums.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vitorota.albums.Album

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
@Dao
interface AlbumDao {
    @Query("SELECT * FROM AlbumEntity")
    suspend fun list(): List<AlbumEntity>

    @Insert
    suspend fun insert(albums: List<AlbumEntity>)
}