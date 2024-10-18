package com.neoutils.highlight.view.extension

import android.text.ParcelableSpan
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.TextStyleScheme
import com.neoutils.highlight.core.scheme.TextColorScheme

fun <T : Any> Scheme<T>.toParcelableSpans(): List<ParcelableSpan?> {

    return when (this) {
        is BackgroundColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                BackgroundColorSpan(
                    it.toInteger()
                )
            }
        }

        is TextColorScheme -> {
            match.values.map {

                if (it == null) return@map null

                ForegroundColorSpan(
                    it.toInteger()
                )
            }
        }

        is TextStyleScheme -> {
            match.values.map {

                if (it == null) return@map null

                StyleSpan(
                    it.toTypeface()
                )
            }
        }

        else -> error("Unknown scheme type")
    }
}
