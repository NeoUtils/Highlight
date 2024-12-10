package com.neoutils.highlight.compose.extension

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Match
import com.neoutils.highlight.core.Match.Group
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.extension.merge
import com.neoutils.highlight.core.extension.range
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.ScriptScheme
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.xregex.extension.findAll

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

fun List<Scheme<*>>.resolved(
    text: String,
    range: IntRange = text.range
): List<Scheme<*>> {

    val schemes = mutableListOf<Scheme<*>>()

    forEach { scheme ->
        when (scheme) {
            is ScriptScheme -> {

                val mergedRange = (scheme.range ?: text.range).merge(range)

                for (result in scheme.regex.findAll(text = text, range = mergedRange)) {

                    val match = scheme.matcher.matches[0] ?: continue

                    schemes.addAll(
                        Highlight {
                            match(
                                Match(
                                    index = result.index,
                                    range = result.range,
                                    text = result.text,
                                    groups = result.groups.map {
                                        it?.let {
                                            Group(
                                                text = it.text,
                                                range = it.range
                                            )
                                        }
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
