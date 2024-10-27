package com.neoutils.highlight.core

import com.neoutils.highlight.core.scope.HighlightScope

data class Highlight(
    val schemes: List<Scheme<*>>,
) {
    constructor(
        vararg schemes: Scheme<*>
    ) : this(schemes.toList())
}

fun highlight(
    scope: HighlightScope.() -> Unit
): Highlight {

    return Highlight(
        HighlightScope().apply(scope).schemes
    )
}
