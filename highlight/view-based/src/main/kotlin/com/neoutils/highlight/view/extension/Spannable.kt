package com.neoutils.highlight.view.extension

import android.text.ParcelableSpan
import android.text.Spannable
import androidx.core.text.getSpans

fun Spannable.removeAllSpans() {
    getSpans<ParcelableSpan>().forEach {
        removeSpan(it)
    }
}

fun Spannable.removeSpans(start: Int = 0, end: Int = length) {
    getSpans<ParcelableSpan>(start, end).forEach {
        removeSpan(it)
    }
}
