package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.plus

fun Highlight.toAnnotatedString(text: String): AnnotatedString {

    val ranges = mutableListOf<AnnotatedString.Range<SpanStyle>>()

    for (scheme in schemes.resolved(text = text)) {

        val spans by lazy { scheme.toSpanStyle() }

        val range = scheme.range ?: IntRange(start = 0, text.lastIndex)

        for (result in text.substring(range).matchAll(scheme.regex.pattern)) {

            for ((index, group) in result.groups.withIndex()) {

                if (group == null) continue
                val span = spans[index] ?: continue

                val groupRange = group.range + range

                ranges.addOrMerge(
                    AnnotatedString.Range(
                        item = span,
                        start = groupRange.first,
                        end = groupRange.last + 1,
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
        it.start < spanStyle.end && spanStyle.start < it.end
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

                add(
                    it.copy(
                        item = it.item.merge(spanStyle.item),
                        start = maxOf(it.start, spanStyle.start),
                        end = minOf(it.end, spanStyle.end)
                    )
                )

                if (it.end > spanStyle.end) {
                    add(it.copy(start = spanStyle.end))
                }
            }
        }
    )

    add(spanStyle)
}
