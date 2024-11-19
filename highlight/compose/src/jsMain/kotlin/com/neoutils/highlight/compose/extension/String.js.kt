package com.neoutils.highlight.compose.extension

import kotlin.js.RegExp

actual fun String.matchAll(
    pattern: String
): List<Match> {

    val jsRegex = RegExp(pattern = pattern, flags = "gd")

    val matches = matchAll(jsRegex)

    return buildList {
        matches.forEach { match ->

            val indices = match.indices

            add(
                Match(
                    text = match.toString(),
                    groups = buildList {
                        match.iterator()
                            .withIndex()
                            .forEach { (index, it) ->
                                val range = indices[index].unsafeCast<IntArray>()

                                add(
                                    Match.Group(
                                        text = it.toString(),
                                        range = range.first() until range.last()
                                    )
                                )
                            }
                    }
                )
            )
        }
    }
}

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
