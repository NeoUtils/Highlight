package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.extension.plus
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.ScriptScheme
import com.neoutils.highlight.core.scheme.TextColorScheme

fun <T : Any> Scheme<T>.toSpanStyle(): Map<Int, SpanStyle> {

    return when (this) {

        is SpanStyleScheme -> matcher.matches

        is TextColorScheme -> {
            matcher.matches.mapValues { (_, uiColor) ->
                SpanStyle(
                    color = uiColor.toColor()
                )
            }
        }

        is BackgroundColorScheme -> {
            matcher.matches.mapValues { (_, uiColor) ->
                SpanStyle(
                    background = uiColor.toColor()
                )
            }
        }

        else -> error("Unknown scheme type $this")
    }
}

fun List<Scheme<*>>.resolved(text: String): List<Scheme<*>> {

    val schemes = mutableListOf<Scheme<*>>()

    forEach { scheme ->
        when (scheme) {
            is ScriptScheme -> {
                val range = scheme.range ?: IntRange(start = 0, text.lastIndex)

                for (result in text.substring(range).matchAll(scheme.regex.pattern)) {

                    val match = scheme.matcher.matches[0] ?: continue

                    schemes.addAll(
                        Highlight {
                            match(
                                result.copy(
                                    range = result.range + range,
                                    groups = result.groups.map { group ->
                                        group?.copy(
                                            range = group.range + range
                                        )
                                    }
                                )
                            )
                        }.schemes
                    )
                }
            }

            else -> {
                schemes.add(scheme)
            }
        }
    }

    return schemes
}
