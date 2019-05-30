package com.vitorota.posts.usecase

import com.vitorota.common.UseCase
import com.vitorota.common.exceptions.RepositoryException
import com.vitorota.posts.Post
import com.vitorota.posts.data.local.PostsLocalRepository
import com.vitorota.posts.data.network.PostsCloudRepository

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class ListUseCase(
    private val localRepository: PostsLocalRepository,
    private val cloudRepository: PostsCloudRepository
) : UseCase<Unit?, List<Post>> {
    override suspend fun execute(args: Unit?): List<Post> {
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