package com.neoutils.highlight.view.extension

import android.graphics.Typeface
import com.neoutils.highlight.view.util.UiStyle

fun UiStyle.toTypeface(): Int {

    return when (this) {
        UiStyle(UiStyle.Style.BOLD) -> Typeface.BOLD
        UiStyle(UiStyle.Style.ITALIC) -> Typeface.ITALIC
        else -> error("Unknown style type")
    }
}
