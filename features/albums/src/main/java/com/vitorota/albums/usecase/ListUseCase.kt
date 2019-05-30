package com.vitorota.albums.usecase

import com.vitorota.albums.Album
import com.vitorota.albums.data.local.AlbumLocalRepository
import com.vitorota.albums.data.network.AlbumCloudRepository
import com.vitorota.common.UseCase
import com.vitorota.common.exceptions.RepositoryException

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class ListUseCase(
    private val localRepository: AlbumLocalRepository,
    private val cloudRepository: AlbumCloudRepository
) : UseCase<Unit?, List<Album>> {

    override suspend fun execute(args: Unit?): List<Album> {
        return try {
            var data = localRepository.list()
            if (data.isNullOrEmpty()) {
                data = cloudRepository.list()
                localRepository.insert(data)
            }

            data
        } catch (e: RepositoryException) {
            //can be different, but for now will be this
            emptyList()
        }
    }
}