package com.vitorota.common.utils

import com.vitorota.common.exceptions.RepositoryException
import kotlinx.coroutines.Deferred

/**
 *
 * @author Vitor Ota
 * @since 22/01/2019
 */
class SynchronousRequestManager<T> {
    @Throws(RepositoryException::class)
    suspend fun getResult(deferred: Deferred<T>): T {
        try {
            return deferred.await()
        } catch (e: Exception) {
            throw RepositoryException(e.message, e)
        }
    }
}