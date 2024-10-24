package com.neoutils.highlight.core.extension

import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scope.HighlightScope

fun highlight(
    scope: HighlightScope.() -> Unit
): Highlight {

    return Highlight(
        HighlightScope().apply(scope).schemes
    )
}
