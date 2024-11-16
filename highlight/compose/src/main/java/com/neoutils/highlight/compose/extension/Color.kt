package com.neoutils.highlight.compose.extension

import androidx.compose.ui.graphics.Color
import com.neoutils.highlight.core.utils.UiColor

fun UiColor.toColor() = when (this) {
    is UiColor.Hex -> Color(android.graphics.Color.parseColor(hex))
    is UiColor.Integer -> Color(colorInt)
    is UiColor.Rgb -> Color(red, green, blue).copy(alpha = alpha)
}