package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Highlight

actual fun Highlight.toAnnotatedString(text: String): AnnotatedString {

    val spanStyles = mutableListOf<AnnotatedString.Range<SpanStyle>>()

    for (scheme in schemes) {

        for (result in scheme.regex.findAll(text)) {

            val spans = scheme.toSpanStyle()

            for ((index, group) in result.groups.withIndex()) {

                if (group == null) continue

                // TODO(improve): this can cause collisions
                val start = result.range.first +
                        result.value.indexOf(group.value)

                val range = IntRange(
                    start = start,
                    endInclusive = start + group.value.lastIndex
                )

                spanStyles.add(
                    AnnotatedString.Range(
                        item = spans.getOrNull(index) ?: continue,
                        start = range.first,
                        end = range.last + 1
                    )
                )
            }
        }
    }

    return AnnotatedString(
        text = text,
        spanStyles = spanStyles
    )
}