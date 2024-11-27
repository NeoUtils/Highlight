package com.neoutils.highlight.view.extension

import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.plus

fun Highlight.applyTo(
    text: Spannable,
    start: Int = 0,
    end: Int = text.length
) {
    for (scheme in schemes.resolved(text.subSequence(0, end), start)) {

        val range = scheme.range ?: IntRange(start = 0, text.lastIndex)

        for (result in scheme.regex.findAll(text.substring(range).subSequence(0, end), start)) {

            val spans by lazy { scheme.toParcelableSpan() }

            for ((index, group) in result.groups.withIndex()) {

                if (group == null) continue
                val span = spans[index] ?: continue

                val groupRange = group.range + range

                text.setSpan(
                    span,
                    groupRange.first,
                    groupRange.last + 1,
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



