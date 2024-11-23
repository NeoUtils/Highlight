package com.neoutils.highlight.core.extension

import com.neoutils.highlight.core.Range

fun <T : Any> MutableList<Range<T>>.addOrOverlap(range: Range<T>) {

    val collisions = filter {
        it.start < range.end &&
                range.start < it.end &&
                it.tag == range.tag &&
                it.level > range.level
    }

    if (collisions.isEmpty()) {
        add(range)
        return
    }

    removeAll(collisions)

    addAll(
        collisions.flatMap {
            buildList {
                if (it.start < range.start) {
                    add(it.copy(end = range.start))
                }
                if (it.end > range.end) {
                    add(it.copy(start = range.end))
                }
            }
        }
    )

    add(range)
}
