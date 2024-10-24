package com.neoutils.highlight.core.utils

@JvmInline
value class UiStyle(
    val style: Style,
) {

    enum class Style {
        BOLD,
        ITALIC,
    }
}