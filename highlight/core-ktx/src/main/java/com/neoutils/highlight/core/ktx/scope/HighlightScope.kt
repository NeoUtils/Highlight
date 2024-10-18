package com.neoutils.highlight.core.ktx.scope

import com.neoutils.highlight.core.Scheme

class HighlightScope internal constructor(
    internal val schemes: MutableList<Scheme<*>> = mutableListOf()
) {
    fun textColor(scope: TextColorScope.() -> Unit) {
        schemes.addAll(
            TextColorScope().apply(scope).schemes
        )
    }

    fun backgroundColor(scope: BackgroundColorScope.() -> Unit) {
        schemes.addAll(
            BackgroundColorScope().apply(scope).schemes
        )
    }

    fun textStyle(scope: TextStyleScope.() -> Unit) {
        schemes.addAll(
            TextStyleScope().apply(scope).schemes
        )
    }
}