package com.neoutils.highlight.view.extension

import android.graphics.Color
import com.neoutils.highlight.core.utils.UiColor

fun UiColor.toIntColor() = when (this) {
    is UiColor.Hex -> Color.parseColor(hex)
    is UiColor.IntColor -> colorInt
    is UiColor.Rgb -> Color.argb((alpha * 0xFF).toInt(), red, green, blue)
}