package com.neoutils.highlight.compose.extension

import com.neoutils.highlight.compose.scope.SpanStyleScope
import com.neoutils.highlight.core.scope.HighlightScope

fun HighlightScope.spanStyle(scope: SpanStyleScope.() -> Unit) {
    schemes.addAll(
        SpanStyleScope().apply(scope).schemes
    )
}