package com.neoutils.highlight.core.utils

import androidx.annotation.ColorInt

/**
 * Common Code Color Utility
 */
sealed class UiColor {

    /**
     * Represents a color in hexadecimal format, typically used for web colors.
     */
    data class Hex(
        val hex: String
    ) : UiColor()

    /**
     * Represents a color in RGBA format, typically used for specifying precise color values in the UI.
     */
    data class Rgb(
        val red: Int = 0,
        val green: Int = 0,
        val blue: Int = 0,
        val alpha: Float = 1f
    ): UiColor()

    /**
     * Represents a color using an integer format, typically used for Android @ColorInt values.
     */
    data class Integer(
        @ColorInt val colorInt: Int
    ) : UiColor()

    companion object {

        val Red = Rgb(red = 0xFF)

        val Green = Rgb(green = 0xFF)

        val Blue = Rgb(blue = 0xFF)

        val White = Rgb(red = 0xFF, green = 0xFF, blue = 0xFF)

        val Black = Rgb()
    }
}
