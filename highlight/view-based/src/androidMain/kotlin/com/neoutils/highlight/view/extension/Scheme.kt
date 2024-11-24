package com.neoutils.highlight.view.extension

import android.graphics.Typeface
import android.text.ParcelableSpan
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.view.scheme.SpanScheme
import com.neoutils.highlight.view.scheme.TextFontScheme
import com.neoutils.highlight.view.scheme.TextStyleScheme
import com.neoutils.highlight.view.span.TextFontSpan
import com.neoutils.highlight.view.util.UiStyle

fun <T : Any> Scheme<T>.toParcelableSpan(): Map<Int, ParcelableSpan?> {

    return when (this) {

        is SpanScheme -> match.matches

        is BackgroundColorScheme -> {
            match.matches.mapValues { (_, uiColor) ->
                uiColor?.let {
                    BackgroundColorSpan(it.toIntColor())
                }
            }
        }

        is TextColorScheme -> {
            match.matches.mapValues { (_, uiColor) ->
                uiColor?.let {
                    ForegroundColorSpan(it.toIntColor())
                }
            }
        }

        is TextStyleScheme -> {
            match.matches.mapValues { (_, uiColor) ->
                uiColor?.let {
                    StyleSpan(
                        when (it) {
                            UiStyle.BOLD -> Typeface.BOLD
                            UiStyle.ITALIC -> Typeface.ITALIC
                            UiStyle.BOLD_ITALIC -> Typeface.BOLD_ITALIC
                        }
                    )
                }
            }
        }

        is TextFontScheme -> {
            match.matches.mapValues { (_, typeface) ->
                typeface?.let {
                    TextFontSpan(
                        typeface = it
                    )
                }
            }
        }

        else -> error("Unknown scheme type $this")
    }
}
