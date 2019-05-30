package com.vitorota.common

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */
interface UseCase<Args, Return> {
    suspend fun execute(args: Args): Return
}