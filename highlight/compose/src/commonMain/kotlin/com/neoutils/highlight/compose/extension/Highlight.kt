package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.TextColorScheme

expect fun Highlight.toAnnotatedString(text: String): AnnotatedString

fun <T : Any> Scheme<T>.toSpanStyle(): List<SpanStyle?> {

    return when (this) {

        is SpanStyleScheme -> match.values

        is TextColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                SpanStyle(
                    color = it.toColor()
                )
            }
        }

        is BackgroundColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                SpanStyle(
                    background = it.toColor()
                )
            }
        }

        else -> error("Unknown scheme type $this")
    }
}
