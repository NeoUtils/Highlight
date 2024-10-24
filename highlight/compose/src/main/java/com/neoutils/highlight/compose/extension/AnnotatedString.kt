package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Scheme

fun Highlight.toAnnotatedString(text: String): AnnotatedString {

    val spanStyles = mutableListOf<AnnotatedString.Range<SpanStyle>>()

    for (scheme in schemes) {

        for (result in scheme.regex.findAll(text)) {

            val spans = scheme.toSpanStyle()

            for ((index, group) in result.groups.withIndex()) {

                if (group == null) continue

                spanStyles.add(
                    AnnotatedString.Range(
                        item = spans.getOrNull(index) ?: continue,
                        start = group.range.first,
                        end = group.range.last + 1
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

private fun <T : Any> Scheme<T>.toSpanStyle(): List<SpanStyle?> {

    return when (this) {

        is SpanStyleScheme -> match.values

        else -> error("Unknown scheme type $this")
    }
}