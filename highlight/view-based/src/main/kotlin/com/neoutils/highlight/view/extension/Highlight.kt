package com.neoutils.highlight.view.extension

import android.graphics.Typeface
import android.text.*
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.view.scheme.SpanScheme
import com.neoutils.highlight.view.scheme.TextFontScheme
import com.neoutils.highlight.view.scheme.TextStyleScheme
import com.neoutils.highlight.view.span.TextFontSpan
import com.neoutils.highlight.view.util.UiStyle

fun Highlight.applyTo(
    text: Spannable,
    start: Int = 0,
    end: Int = text.length
) {

    for (scheme in schemes) {

        for (result in scheme.regex.findAll(text.subSequence(0, end), start)) {

            val spans = scheme.toParcelableSpans()

            for ((index, group) in result.groups.withIndex()) {

                if (group == null) continue

                text.setSpan(
                    spans.getOrNull(index),
                    group.range.first,
                    group.range.last + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
    }
}

fun Highlight.toSpannedString(
    text: String
): SpannedString {

    return SpannedString.valueOf(
        SpannableString(text).apply(::applyTo)
    )
}

private fun <T : Any> Scheme<T>.toParcelableSpans(): List<ParcelableSpan?> {

    return when (this) {

        is SpanScheme -> match.values

        is BackgroundColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                BackgroundColorSpan(it.toIntColor())
            }
        }

        is TextColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                ForegroundColorSpan(it.toIntColor())
            }
        }

        is TextStyleScheme -> {
            match.values.map {

                if (it == null) return@map null

                StyleSpan(
                    when (it) {
                        UiStyle.BOLD -> Typeface.BOLD
                        UiStyle.ITALIC -> Typeface.ITALIC
                        UiStyle.BOLD_ITALIC -> Typeface.BOLD_ITALIC
                    }
                )
            }
        }

        is TextFontScheme -> {
            match.values.map {
                TextFontSpan(
                    typeface = it ?: return@map null
                )
            }
        }

        else -> error("Unknown scheme type $this")
    }
}


