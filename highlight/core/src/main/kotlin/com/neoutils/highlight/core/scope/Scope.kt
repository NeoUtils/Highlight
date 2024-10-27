package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme

abstract class Scope<T : Scheme<*>> internal constructor(
    protected val builder: MutableList<T> = mutableListOf()
) {
    val schemes get() = builder.toList()

    fun addSchemes(schemes: List<T>) = builder.addAll(schemes)
}