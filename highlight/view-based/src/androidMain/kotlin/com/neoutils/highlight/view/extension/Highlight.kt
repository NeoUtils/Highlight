package com.neoutils.highlight.view.extension

import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.Range
import com.neoutils.highlight.core.extension.addOrOverlap

fun Highlight.applyTo(
    text: Spannable,
    start: Int = 0,
    end: Int = text.length
) {

    val spans = buildList {
        for (scheme in schemes.sortedByDescending { it.level }) {

            val spans by lazy { scheme.toParcelableSpan() }

            for (result in scheme.regex.findAll(text.subSequence(0, end), start)) {

                for ((index, group) in result.groups.withIndex()) {

                    if (group == null) continue
                    if (!spans.containsKey(index)) continue

                    addOrOverlap(
                        Range(
                            item = spans[index],
                            start = group.range.first,
                            end = group.range.last + 1,
                            level = scheme.level,
                            tag = scheme.tag
                        )
                    )
                }
            }
        }
    }

    spans.forEach {
        if (it.item != null) {
            text.setSpan(
                it.item,
                it.start,
                it.end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
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



