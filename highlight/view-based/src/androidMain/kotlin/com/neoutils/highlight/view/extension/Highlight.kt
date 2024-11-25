package com.neoutils.highlight.view.extension

import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import com.neoutils.highlight.core.Highlight

fun Highlight.applyTo(
    text: Spannable,
    start: Int = 0,
    end: Int = text.length
) {
    for (scheme in schemes) {

        val spans by lazy { scheme.toParcelableSpan() }

        for (result in scheme.regex.findAll(text.subSequence(0, end), start)) {

            for ((index, group) in result.groups.withIndex()) {

                if (group == null) continue

                text.setSpan(
                    spans[index] ?: continue,
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



