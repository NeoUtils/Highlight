package com.neoutils.highlight.compose.extension

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.StyleTextScheme
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.core.utils.UiStyle

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
        is BackgroundColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                SpanStyle(
                    background = it.toColor()
                )
            }
        }

        is TextColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                SpanStyle(
                    color = it.toColor()
                )

            }
        }

        is StyleTextScheme -> {
            match.values.map {

                if (it == null) return@map null

                when (it.style) {
                    UiStyle.Style.BOLD -> {
                        SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    }

                    UiStyle.Style.ITALIC -> {
                        SpanStyle(
                            fontStyle = FontStyle.Italic
                        )
                    }

                }
            }
        }

        else -> error("Unknown scheme type")
    }
}

fun UiColor.toColor(): Color {

    return when (this) {
        is UiColor.Hex -> Color(android.graphics.Color.parseColor(hex))
        is UiColor.Raw -> Color(value)
        is UiColor.Rgb -> {
            Color(
                red = red,
                green = green,
                blue = blue,
            ).copy(alpha = alpha)
        }
    }
}

