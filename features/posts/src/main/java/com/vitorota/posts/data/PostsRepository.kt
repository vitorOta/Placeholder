package com.vitorota.posts.data

import com.vitorota.common.ListRepository
import com.vitorota.common.ToBean
import com.vitorota.posts.Post


/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */

interface PostsRepository<Type : ToBean<Post>> : ListRepository<Post> {
    fun fromBean(post: Post): Type
}