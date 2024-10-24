package com.neoutils.highlight.view.util

@JvmInline
value class UiStyle(
    val style: Style,
) {

    enum class Style {
        BOLD,
        ITALIC,
    }
}