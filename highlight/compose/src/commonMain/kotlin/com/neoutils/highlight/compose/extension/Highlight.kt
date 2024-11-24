package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Range
import com.neoutils.highlight.core.extension.addOrOverlap

fun Highlight.toAnnotatedString(text: String): AnnotatedString {

    val spans = buildList {
        for (scheme in schemes.sortedByDescending { it.level }) {

            val spans by lazy { scheme.toSpanStyle() }

            for (result in text.matchAll(scheme.regex.pattern)) {

                for ((index, group) in result.groups.withIndex()) {

                    if (group == null) continue
                    if (!spans.containsKey(index)) continue

                    addOrOverlap(
                        Range(
                            item = spans[index],
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
        spanStyles = spans.mapNotNull {
            AnnotatedString.Range(
                item = it.item ?: return@mapNotNull null,
                start = it.start,
                end = it.end
            )
        }
    )
}
