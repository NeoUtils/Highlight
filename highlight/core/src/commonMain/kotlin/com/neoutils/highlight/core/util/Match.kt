package com.neoutils.highlight.core.util

data class Match<T : Any>(
    val values: List<T?>,
) {
    companion object {

        fun <T : Any> fully(
            value: T
        ) = Match(listOf(value))

        fun <T : Any> groups(
            values: List<T?>
        ) = Match(values = listOf(null) + values)

        fun <T : Any> groups(
            vararg values: T?
        ) = Match(listOf(null, *values))
    }
}