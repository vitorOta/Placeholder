package com.vitorota.albums.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
@Database(
    entities = [AlbumEntity::class],
    version = 1
)
abstract class AlbumDb : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}