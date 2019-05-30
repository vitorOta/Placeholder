package com.vitorota.posts.di

import androidx.room.Room
import com.vitorota.common.API_URL
import com.vitorota.network.ApiClientBuilder
import com.vitorota.posts.data.local.PostsDb
import com.vitorota.posts.data.local.PostsLocalRepository
import com.vitorota.posts.data.network.PostsApi
import com.vitorota.posts.data.network.PostsCloudRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */

internal val localModule = module {
    //db
    single {
        Room.databaseBuilder(
            androidContext(),
            PostsDb::class.java,
            "postsdb"
        ).build()
    }

    //dao
    factory { get<PostsDb>().postsDao() }

    //repository
    factory {
        PostsLocalRepository(get())
    }

}

internal val networkModule = module {
    //api
    single {
        ApiClientBuilder.createServiceApi(
            PostsApi::class.java,
            API_URL
        )
    }

    //repository
    factory {
        PostsCloudRepository(get())
    }
}