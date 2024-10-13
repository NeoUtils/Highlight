package com.neoutils.highlight.core.utils

object Match {

    fun <T : Any> full(
        value: T
    ): List<T> {
        return listOf(value)
    }

    fun <T : Any> group(
        vararg values: T
    ): List<T?> {
        return listOf(null, *values)
    }
}