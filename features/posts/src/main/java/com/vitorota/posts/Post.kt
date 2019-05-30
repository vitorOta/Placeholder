package com.vitorota.posts

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
data class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)