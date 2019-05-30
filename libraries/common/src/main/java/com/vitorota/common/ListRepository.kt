package com.vitorota.common

import com.vitorota.common.exceptions.RepositoryException

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
interface ListRepository<T> {
    @Throws(RepositoryException::class)
    suspend fun list(): List<T>
}