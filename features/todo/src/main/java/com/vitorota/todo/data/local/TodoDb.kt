package com.vitorota.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */

@Database(
    entities = [TodoEntity::class],
    version = 1
)
internal abstract class TodoDb : RoomDatabase() {
    abstract fun todoDao(): TodoDao

}