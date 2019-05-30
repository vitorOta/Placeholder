package com.vitorota.common.extensions

import com.vitorota.common.ToBean

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */

fun <T> List<ToBean<T>>.toBean() = this.map { it.toBean() }