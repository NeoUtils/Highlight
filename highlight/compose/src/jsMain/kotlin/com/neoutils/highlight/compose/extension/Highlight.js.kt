package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Highlight

actual fun Highlight.toAnnotatedString(text: String): AnnotatedString {

    val spanStyles = mutableListOf<AnnotatedString.Range<SpanStyle>>()

    for (scheme in schemes) {

        val spans = scheme.toSpanStyle()
        val regex = scheme.regex.pattern

        for ((index, match) in regex.matchAllWithGroups(text).withIndex()) {
            spanStyles.add(
                AnnotatedString.Range(
                    item = spans.getOrNull(index) ?: continue,
                    start = match.range.first,
                    end = match.range.last + 1
                )
            )
        }
    }

    return AnnotatedString(
        text = text,
        spanStyles = spanStyles
    )
}
