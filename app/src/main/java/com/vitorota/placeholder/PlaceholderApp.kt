package com.vitorota.placeholder

import android.app.Application
import com.vitorota.posts.di.PostsModule
import com.vitorota.todo.di.TodoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
class PlaceholderApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    fun setupKoin() {
        startKoin {
            androidContext(this@PlaceholderApp)
            modules(
                listOf(
                    *TodoModule.getModules(),
                    *PostsModule.getModules()
                )
            )
        }
    }
}