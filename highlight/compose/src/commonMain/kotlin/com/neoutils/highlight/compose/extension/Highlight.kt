package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.TextColorScheme

fun Highlight.toAnnotatedString(text: String): AnnotatedString {

    return AnnotatedString(
        text = text,
        spanStyles = buildList {
            for (scheme in schemes) {

                val spans by lazy { scheme.toSpanStyle() }

                for (result in text.matchAll(scheme.regex.pattern)) {

                    for ((index, group) in result.groups.withIndex()) {

                        if (group == null) continue
                        val spanStyle = spans[index] ?: continue

                        add(
                            AnnotatedString.Range(
                                item = spanStyle,
                                start = group.range.first,
                                end = group.range.last + 1
                            )
                        )
                    }
                }
            }
        }
    )
}


private fun <T : Any> Scheme<T>.toSpanStyle(): Map<Int, SpanStyle> {

    return when (this) {

        is SpanStyleScheme -> match.matches

        is TextColorScheme -> {
            match.matches.mapValues {
                SpanStyle(
                    color = it.value.toColor()
                )
            }
        }

        is BackgroundColorScheme -> {
            match.matches.mapValues {
                SpanStyle(
                    background = it.value.toColor()
                )
            }
        }

        else -> error("Unknown scheme type $this")
    }
}
