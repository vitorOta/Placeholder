package com.vitorota.posts.di

import com.vitorota.posts.ui.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */

internal val uiModule = module {
    viewModel { PostsViewModel(get()) }
}