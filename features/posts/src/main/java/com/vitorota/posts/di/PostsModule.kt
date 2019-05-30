package com.vitorota.posts.di

import org.koin.core.module.Module

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
object PostsModule {
    fun getModules(): Array<Module> {
        return arrayOf(
            localModule,
            networkModule,

            useCaseModule,

            uiModule
        )
    }
}