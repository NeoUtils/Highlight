package com.neoutils.highlight.view.extension

import com.neoutils.highlight.core.scope.HighlightScope
import com.neoutils.highlight.core.scope.BackgroundColorScope
import com.neoutils.highlight.core.scope.TextColorScope
import com.neoutils.highlight.view.scope.TextFontScope
import com.neoutils.highlight.view.scope.TextStyleScope

fun HighlightScope.textFont(scope: TextFontScope.() -> Unit) {
    addSchemes(TextFontScope().apply(scope).schemes)
}

fun HighlightScope.textStyle(scope: TextStyleScope.() -> Unit) {
    addSchemes(TextStyleScope().apply(scope).schemes)
}
