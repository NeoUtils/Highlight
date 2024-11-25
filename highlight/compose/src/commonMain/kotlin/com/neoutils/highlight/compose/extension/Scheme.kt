package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.TextColorScheme

fun <T : Any> Scheme<T>.toSpanStyle(): Map<Int, SpanStyle> {

    return when (this) {

        is SpanStyleScheme -> match.matches

        is TextColorScheme -> {
            match.matches.mapValues { (_, uiColor) ->
                SpanStyle(
                    color = uiColor.toColor()
                )
            }
        }

        is BackgroundColorScheme -> {
            match.matches.mapValues { (_, uiColor) ->
                SpanStyle(
                    background = uiColor.toColor()
                )
            }
        }

        else -> error("Unknown scheme type $this")
    }
}
