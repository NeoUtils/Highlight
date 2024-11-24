package com.neoutils.highlight.core.extension

import com.neoutils.highlight.core.SpanRange

fun <T : Any> MutableList<SpanRange<T>>.addOrOverlap(
    spanRange: SpanRange<T>
) {

    val collisions = filter {
        it.start < spanRange.end &&
                spanRange.start < it.end &&
                it.level > spanRange.level
    }

    if (collisions.isEmpty()) {
        add(spanRange)
        return
    }

    removeAll(collisions)

    addAll(
        collisions.flatMap {
            buildList {
                if (it.start < spanRange.start) {
                    add(it.copy(end = spanRange.start))
                }
                if (it.end > spanRange.end) {
                    add(it.copy(start = spanRange.end))
                }
            }
        }
    )

    add(spanRange)
}
