package com.neoutils.highlight.view.extension

import android.text.ParcelableSpan
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.ForegroundColorScheme
import com.neoutils.highlight.core.scheme.StyleTextScheme

fun <T : Any> Scheme<T>.toSpans(): List<ParcelableSpan?> {
    return when (this) {
        is BackgroundColorScheme -> {
            values.map {
                it?.let {
                    BackgroundColorSpan(
                        it.toInteger()
                    )
                }
            }
        }

        is ForegroundColorScheme -> {
            values.map {
                it?.let {
                    ForegroundColorSpan(
                        it.toInteger()
                    )
                }
            }
        }

        is StyleTextScheme -> {
            values.map {
                it?.let {
                    StyleSpan(
                        it.toTypeface()
                    )
                }
            }
        }

        else -> error("Unknown scheme type")
    }
}
