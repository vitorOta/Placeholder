package com.vitorota.posts.data.network

import com.vitorota.common.extensions.toBean
import com.vitorota.common.utils.SynchronousRequestManager
import com.vitorota.posts.Post
import com.vitorota.posts.data.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class PostsCloudRepository(private var api: PostsApi) : PostsRepository<PostSchema> {
    override fun fromBean(post: Post) = PostSchema(
        userId = post.userId,
        id = post.id,
        title = post.title,
        body = post.body
    )

    override suspend fun list(): List<Post> {
        return withContext(Dispatchers.IO) {
            SynchronousRequestManager<List<PostSchema>>().getResult(api.list())
                .toBean()
        }
    }
}