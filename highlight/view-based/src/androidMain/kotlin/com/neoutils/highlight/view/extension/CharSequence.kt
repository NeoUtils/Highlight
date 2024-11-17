package com.neoutils.highlight.view.extension

fun CharSequence.getLastLineEnd(
    end: Int
): Int {
    var lineEnd = end

    while (lineEnd < length) {
        val c: Char = get(lineEnd)

        if (c == '\n') {
            break
        }

        lineEnd++
    }

    return lineEnd
}

fun CharSequence.getFirstLineStart(
    start: Int
): Int {
    var lineStart = start

    while (lineStart > 0) {
        val c: Char = get(lineStart - 1)

        if (c == '\n') {
            break
        }

        lineStart--
    }

    return lineStart
}
