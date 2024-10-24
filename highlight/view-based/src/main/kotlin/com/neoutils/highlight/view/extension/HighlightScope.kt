package com.neoutils.highlight.view.extension

import com.neoutils.highlight.core.scope.HighlightScope
import com.neoutils.highlight.view.scope.BackgroundColorScope
import com.neoutils.highlight.view.scope.TextColorScope
import com.neoutils.highlight.view.scope.TextFontScope
import com.neoutils.highlight.view.scope.TextStyleScope

fun HighlightScope.textFont(scope: TextFontScope.() -> Unit) {
    schemes.addAll(
        TextFontScope().apply(scope).schemes
    )
}

fun HighlightScope.textStyle(scope: TextStyleScope.() -> Unit) {
    schemes.addAll(
        TextStyleScope().apply(scope).schemes
    )
}

fun HighlightScope.textColor(scope: TextColorScope.() -> Unit) {
    schemes.addAll(
        TextColorScope().apply(scope).schemes
    )
}

fun HighlightScope.backgroundColor(scope: BackgroundColorScope.() -> Unit) {
    schemes.addAll(
        BackgroundColorScope().apply(scope).schemes
    )
}