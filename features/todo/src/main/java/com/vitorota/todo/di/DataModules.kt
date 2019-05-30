package com.vitorota.todo.di

import androidx.room.Room
import com.vitorota.network.ApiClientBuilder
import com.vitorota.todo.data.local.TodoDb
import com.vitorota.todo.data.local.TodoLocalRepository
import com.vitorota.todo.data.network.TodoApi
import com.vitorota.todo.data.network.TodoCloudRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */

internal val localModule = module {
    //db
    single {
        Room.databaseBuilder(
            androidContext(),
            TodoDb::class.java,
            "tododb"
        ).build()
    }

    //dao
    factory { get<TodoDb>().todoDao() }

    //repository
    factory {
        TodoLocalRepository(get())
    }

}

internal val networkModule = module {
    //api
    single {
        ApiClientBuilder.createServiceApi(
            TodoApi::class.java,
            API_URL
        )
    }

    //repository
    factory {
        TodoCloudRepository(get())
    }
}