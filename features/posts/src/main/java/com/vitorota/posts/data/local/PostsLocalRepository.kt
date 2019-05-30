package com.vitorota.posts.data.local

import com.vitorota.common.extensions.toBean
import com.vitorota.posts.Post
import com.vitorota.posts.data.PostsRepository

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class PostsLocalRepository(private val dao: PostsDao) : PostsRepository<PostEntity> {
    override fun fromBean(post: Post) = PostEntity(
        userId = post.userId,
        id = post.id,
        title = post.title,
        body = post.body
    )

    override suspend fun list(): List<Post> {
        return dao.list().toBean()
    }

    suspend fun insert(posts: List<Post>) {
        dao.insert(posts.map { fromBean(it) })
    }
}