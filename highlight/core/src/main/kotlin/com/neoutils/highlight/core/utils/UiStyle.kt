package com.neoutils.highlight.core.utils

data class UiStyle(
    val style: Style,
) {

    enum class Style {
        BOLD,
        ITALIC,
    }
}