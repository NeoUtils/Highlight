package com.neoutils.highlight.core

data class Highlight(
    val schemes: List<Scheme<*>>,
) {
    constructor(
        vararg schemes: Scheme<*>
    ) : this(schemes.toList())
}
