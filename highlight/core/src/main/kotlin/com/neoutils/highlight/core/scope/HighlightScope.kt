package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme

class HighlightScope internal constructor(
    val schemes: MutableList<Scheme<*>> = mutableListOf()
)
