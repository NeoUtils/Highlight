package com.neoutils.highlight.compose.extension

actual fun String.matchAll(
    pattern: String,
): List<Match> {

    val matches = Regex(
        pattern = pattern
    ).findAll(input = this)

    return buildList {
        matches.forEach { match ->
            add(
                Match(
                    text = match.value,
                    groups = match.groups.map {

                        if (it == null) return@map null

                        Match.Group(
                            text = it.value,
                            range = it.range
                        )
                    }
                )
            )
        }
    }
}
