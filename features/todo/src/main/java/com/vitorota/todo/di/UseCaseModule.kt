package com.vitorota.todo.di

import com.vitorota.todo.usecase.ListUseCase
import org.koin.dsl.module

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */

internal val useCaseModule = module {
    factory {
        ListUseCase(get(), get())
    }
}