package com.neoutils.highlight.compose.extension

data class Match(
    val range: IntRange,
    val text: String,
    val groups: List<Group?>
) {
    data class Group(
        val text: String,
        val range: IntRange
    )
}

expect fun String.matchAll(pattern: String): List<Match>
