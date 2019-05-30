package com.vitorota.posts.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vitorota.common.ToBean
import com.vitorota.posts.Post

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */

@Entity
data class PostEntity(
    var userId: Int,
    @PrimaryKey
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