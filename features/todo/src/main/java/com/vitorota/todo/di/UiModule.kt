package com.vitorota.todo.di

import com.vitorota.todo.ui.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */

internal val uiModule = module {
    viewModel { TodoViewModel(get()) }
}