package com.vitorota.posts.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */

@Dao
interface PostsDao {
    @Query("SELECT * FROM PostEntity")
    suspend fun list(): List<PostEntity>

    @Insert
    suspend fun insert(list: List<PostEntity>)
}