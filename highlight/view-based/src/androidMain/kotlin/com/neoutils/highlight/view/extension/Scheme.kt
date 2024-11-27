package com.neoutils.highlight.view.extension

import Match
import android.graphics.Typeface
import android.text.ParcelableSpan
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.ScriptScheme
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.view.scheme.SpanScheme
import com.neoutils.highlight.view.scheme.TextFontScheme
import com.neoutils.highlight.view.scheme.TextStyleScheme
import com.neoutils.highlight.view.span.TextFontSpan
import com.neoutils.highlight.view.util.UiStyle

fun <T : Any> Scheme<T>.toParcelableSpan(): Map<Int, ParcelableSpan> {

    return when (this) {

        is SpanScheme -> matcher.matches

        is BackgroundColorScheme -> {
            matcher.matches.mapValues { (_, uiColor) ->
                BackgroundColorSpan(uiColor.toIntColor())
            }
        }

        is TextColorScheme -> {
            matcher.matches.mapValues { (_, uiColor) ->
                ForegroundColorSpan(uiColor.toIntColor())
            }
        }

        is TextStyleScheme -> {
            matcher.matches.mapValues { (_, uiColor) ->
                StyleSpan(
                    when (uiColor) {
                        UiStyle.BOLD -> Typeface.BOLD
                        UiStyle.ITALIC -> Typeface.ITALIC
                        UiStyle.BOLD_ITALIC -> Typeface.BOLD_ITALIC
                    }
                )
            }
        }

        is TextFontScheme -> {
            matcher.matches.mapValues { (_, typeface) ->
                TextFontSpan(
                    typeface = typeface
                )
            }
        }

        else -> error("Unknown scheme type $this")
    }
}

fun List<Scheme<*>>.resolveScript(text: CharSequence, start: Int): List<Scheme<*>> {

    val schemes = mutableListOf<Scheme<*>>()

    for (scheme in this) {

        if (scheme is ScriptScheme) {

            for ((index, result) in scheme.regex.findAll(text, start).withIndex()) {

                val match = scheme.matcher.matches[0] ?: continue

                schemes.addAll(
                    Highlight {
                        match(Match(index, result))
                    }.schemes
                )
            }
            continue
        }

        schemes.add(scheme)
    }

    return schemes
}
