package com.neoutils.highlight.view.extension

import android.text.Spannable
import android.text.Spanned
import com.neoutils.highlight.core.Highlight

fun Highlight.applyTo(
    text: Spannable,
    start: Int = 0,
    end: Int = text.length
) {

    for (scheme in schemes) {

        for (result in scheme.regex.findAll(text.subSequence(0, end), start)) {

            val spans = scheme.toSpans()

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

