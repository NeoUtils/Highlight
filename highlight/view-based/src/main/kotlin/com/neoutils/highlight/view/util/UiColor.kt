package com.neoutils.highlight.view.util

import android.graphics.Color
import androidx.annotation.ColorInt

@JvmInline
value class UiColor(
    @ColorInt
    val colorInt: Int
) {
    companion object {

        val Red = rgb(red = 255)

        val Green = rgb(green = 255)

        val Blue = rgb(blue = 255)

        val White = rgb(red = 255, green = 255, blue = 255)

        val Black = rgb()

        fun rgb(
            red: Int = 0,
            green: Int = 0,
            blue: Int = 0,
            alpha: Float = 1f
        ): UiColor {

            return UiColor(Color.argb((alpha * 255).toInt(), red, green, blue))
        }

        fun hex(hex: String): UiColor {

            return UiColor(Color.parseColor(hex))
        }
    }
}