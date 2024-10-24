package com.neoutils.highlight.view.extension

import android.graphics.Color
import com.neoutils.highlight.view.util.UiColor

fun UiColor.toInteger(): Int {

    return when (this) {
        is UiColor.Hex -> Color.parseColor(hex)
        is UiColor.Raw -> value
        is UiColor.Rgb -> Color.argb((alpha * 255).toInt(), red, green, blue)
        else -> error("Unknown color type")
    }
}
