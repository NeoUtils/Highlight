package com.neoutils.highlight.compose.extension

import androidx.compose.ui.graphics.Color
import com.neoutils.highlight.core.utils.UiColor

fun UiColor.toColor() = when (this) {
    is UiColor.Hex -> hex.toColor()
    is UiColor.Integer -> Color(colorInt)
    is UiColor.Rgb -> Color(red, green, blue).copy(alpha = alpha)
}

fun String.toColor(): Color {

    val cleared = removePrefix(prefix = "#")
    val colorInt = cleared.toLong(radix = 16)

    return Color(
        alpha = if (cleared.length == 8) {
            (colorInt shr 24 and 0xFF).toInt()
        } else {
            0xFF
        },
        red = (colorInt shr 16 and 0xFF).toInt(),
        green = (colorInt shr 8 and 0xFF).toInt(),
        blue = (colorInt and 0xFF).toInt()
    )
}