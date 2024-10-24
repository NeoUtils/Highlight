package com.neoutils.highlight.core.utils

data class Match<T : Any>(
    val values: List<T?>,
) {
    companion object {

        @JvmStatic
        fun <T : Any> fully(
            value: T
        ) = Match(listOf(value))

        @JvmStatic
        fun <T : Any> groups(
            values: List<T?>
        ) = Match(values = listOf(null) + values)

        @JvmStatic
        fun <T : Any> groups(
            vararg values: T?
        ) = Match(listOf(null, *values))
    }
}