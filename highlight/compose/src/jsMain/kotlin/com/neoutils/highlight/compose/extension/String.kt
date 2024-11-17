package com.neoutils.highlight.compose.extension

import kotlin.js.RegExp

data class Match(
    val text: String,
    val range: IntRange
)

fun String.matchAll(jsRegex: RegExp): List<dynamic> {

    val result = asDynamic().matchAll(jsRegex)

    return buildList {
        var current = result.next()

        while (current.done == false) {
            add(current.value)
            current = result.next()
        }
    }
}

fun String.matchAllWithGroups(text: String): List<Match> {
    val jsRegex = RegExp(pattern = this, flags = "gd")

    val matches = text.matchAll(jsRegex)

    return buildList {
        for (match in matches) {
            val indices = match.indices

            for ((index, it) in match.iterator().withIndex()) {
                val range = indices[index].unsafeCast<IntArray>()

                add(
                    Match(
                        text = it.toString(),
                        range = range.first() until range.last()
                    )
                )
            }
        }
    }
}
