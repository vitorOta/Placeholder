package com.vitorota.todo

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */
data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)