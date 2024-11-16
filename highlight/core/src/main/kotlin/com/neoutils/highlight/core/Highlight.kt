package com.neoutils.highlight.core

import com.neoutils.highlight.core.scope.HighlightScope

data class Highlight(
    val schemes: List<Scheme<*>>,
) {
    constructor(
        vararg schemes: Scheme<*>
    ) : this(schemes.toList())

    constructor(
        builder: HighlightScope.() -> Unit
    ) : this(HighlightScope().apply(builder).schemes)
}
