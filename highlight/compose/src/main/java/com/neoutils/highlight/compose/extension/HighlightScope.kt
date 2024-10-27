package com.neoutils.highlight.compose.extension

import com.neoutils.highlight.compose.scope.BackgroundScope
import com.neoutils.highlight.compose.scope.SpanStyleScope
import com.neoutils.highlight.compose.scope.TextColorScope
import com.neoutils.highlight.core.scope.HighlightScope

fun HighlightScope.spanStyle(scope: SpanStyleScope.() -> Unit) {
    addSchemes(SpanStyleScope().apply(scope).schemes)
}

fun HighlightScope.textColor(scope: TextColorScope.() -> Unit) {
    addSchemes(TextColorScope().apply(scope).schemes)
}

fun HighlightScope.backgroundColor(scope: BackgroundScope.() -> Unit) {
    addSchemes(BackgroundScope().apply(scope).schemes)
}
