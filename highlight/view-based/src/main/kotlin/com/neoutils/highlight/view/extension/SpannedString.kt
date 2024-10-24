package com.neoutils.highlight.view.extension

import android.text.SpannableString
import android.text.SpannedString
import com.neoutils.highlight.core.Highlight

fun Highlight.toSpannedString(
    text: String
): SpannedString {

    return SpannedString.valueOf(
        SpannableString(text).apply(::applyTo)
    )
}

