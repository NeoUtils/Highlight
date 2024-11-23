package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.addOrOverlap
import com.neoutils.highlight.core.Range

fun Highlight.toAnnotatedString(text: String): AnnotatedString {

    val spans = buildList {
        for (scheme in schemes.sortedByDescending { it.level }) {

            val spans by lazy { scheme.toSpanStyle() }

            for (result in text.matchAll(scheme.regex.pattern)) {

                for ((index, group) in result.groups.withIndex()) {

                    if (group == null) continue
                    val spanStyle = spans[index] ?: continue

                    addOrOverlap(
                        Range(
                            item = spanStyle,
                            start = group.range.first,
                            end = group.range.last + 1,
                            level = scheme.level,
                            tag = scheme.tag
                        )
                    )
                }
            }
        }
    }

    return AnnotatedString(
        text = text,
        spanStyles = spans.map {
            AnnotatedString.Range(
                item = it.item,
                start = it.start,
                end = it.end
            )
        }
    )
}
