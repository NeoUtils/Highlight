package com.neoutils.highlight.core.ktx

import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.ktx.scope.HighlightScope

fun highlight(
    scope: HighlightScope.() -> Unit
): Highlight {

    return Highlight(
        HighlightScope().apply(scope).schemes
    )
}
