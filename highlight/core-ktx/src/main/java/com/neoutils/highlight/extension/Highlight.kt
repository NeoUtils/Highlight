package com.neoutils.highlight.extension

import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.extension.scope.HighlightScope

fun highlight(
    scope: HighlightScope.() -> Unit
): Highlight {

    return Highlight(
        HighlightScope().apply(scope).schemes
    )
}
