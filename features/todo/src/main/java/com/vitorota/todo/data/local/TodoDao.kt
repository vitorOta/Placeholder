package com.vitorota.todo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */

@Dao
interface TodoDao {
    @Query("SELECT * FROM TodoEntity")
    suspend fun list(): List<TodoEntity>

    @Insert
    suspend fun insert(list: List<TodoEntity>)
}