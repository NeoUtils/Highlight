package com.neoutils.highlight.core.utils

import androidx.annotation.ColorInt

sealed class UiColor {

    data class Hex(
        val hex: String
    ) : UiColor()

    data class Rgb(
        val red: Int = 0,
        val green: Int = 0,
        val blue: Int = 0,
        val alpha: Float = 1f
    ) : UiColor()

    data class Raw(
        @ColorInt
        val value: Int
    ) : UiColor()

    companion object {
        val Blue = Rgb(blue = 255)

        val Red = Rgb(red = 255)

        val Green = Rgb(green = 255)

        val White = Rgb(red = 255, green = 255, blue = 255)

        val Black = Rgb()
    }
}
