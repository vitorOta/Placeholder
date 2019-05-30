package com.vitorota.albums.di

import androidx.room.Room
import com.vitorota.albums.data.local.AlbumDb
import com.vitorota.albums.data.local.AlbumLocalRepository
import com.vitorota.albums.data.network.AlbumCloudRepository
import com.vitorota.albums.data.network.AlbumsApi
import com.vitorota.common.API_URL
import com.vitorota.network.ApiClientBuilder
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
            AlbumDb::class.java,
            "albumsdb"
        ).build()
    }

    //dao
    factory { get<AlbumDb>().albumDao() }

    //repository
    factory {
        AlbumLocalRepository(get())
    }

}

internal val networkModule = module {
    //api
    single {
        ApiClientBuilder.createServiceApi(
            AlbumsApi::class.java,
            API_URL
        )
    }

    //repository
    factory {
        AlbumCloudRepository(get())
    }
}