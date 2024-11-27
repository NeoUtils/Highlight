package com.neoutils.highlight.core.extension

infix operator fun IntRange.plus(range: IntRange): IntRange {
    return IntRange(
        start = start + range.first,
        endInclusive = endInclusive + range.first
    )
}
