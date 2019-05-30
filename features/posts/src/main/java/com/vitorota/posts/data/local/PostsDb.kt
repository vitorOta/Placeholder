package com.vitorota.posts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
@Database(
    entities = [PostEntity::class],
    version = 1
)
internal abstract class PostsDb : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}