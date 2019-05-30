package com.vitorota.posts.data.network

import com.vitorota.common.ToBean
import com.vitorota.posts.Post

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
data class PostSchema(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
) : ToBean<Post> {
    override fun toBean() = Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}