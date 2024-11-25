package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Highlight

fun Highlight.toAnnotatedString(text: String): AnnotatedString {

    val ranges = mutableListOf<AnnotatedString.Range<SpanStyle>>()

    for (scheme in schemes) {

        val spans by lazy { scheme.toSpanStyle() }

        for (result in text.matchAll(scheme.regex.pattern)) {

            for ((index, group) in result.groups.withIndex()) {

                if (group == null) continue

                ranges.addOrMerge(
                    AnnotatedString.Range(
                        item = spans[index] ?: continue,
                        start = group.range.first,
                        end = group.range.last + 1,
                    )
                )
            }
        }
    }

    return AnnotatedString(
        text = text,
        spanStyles = ranges
    )
}

fun MutableList<AnnotatedString.Range<SpanStyle>>.addOrMerge(
    spanStyle: AnnotatedString.Range<SpanStyle>
) {

    val collisions = filter {
        it.start < spanStyle.end &&
                spanStyle.start < it.end
    }

    if (collisions.isEmpty()) {
        add(spanStyle)
        return
    }

    removeAll(collisions)

    addAll(
        collisions.flatMap {
            buildList {
                if (it.start < spanStyle.start) {
                    add(it.copy(end = spanStyle.start))
                }

                if (it.start < spanStyle.end && it.end > spanStyle.start) {
                    val start = maxOf(it.start, spanStyle.start)
                    val end = minOf(it.end, spanStyle.end)

                    add(
                        it.copy(
                            item = it.item.merge(spanStyle.item),
                            start = start,
                            end = end
                        )
                    )
                }

                if (it.end > spanStyle.end) {
                    add(it.copy(start = spanStyle.end))
                }
            }
        }
    )

    add(spanStyle)
}
