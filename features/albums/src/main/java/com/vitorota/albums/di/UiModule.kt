package com.vitorota.albums.di

import com.vitorota.albums.ui.AlbumsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */

internal val uiModule = module {
    viewModel { AlbumsViewModel(get()) }
}