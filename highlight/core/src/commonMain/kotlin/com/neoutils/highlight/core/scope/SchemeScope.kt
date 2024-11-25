package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.Scope
import com.neoutils.highlight.core.util.Match

abstract class SchemeScope<T : Any, S : Scheme<*>> : Scope<S>() {

    protected abstract fun addScheme(
        regex: Regex,
        match: Match<T>,
        level: Int?
    )

    fun Regex.match(
        level: Int? = null,
        scope: MutableMap<Int, T?>.() -> Unit
    ) = addScheme(
        regex = this,
        match = Match(
            matches = buildMap(scope)
        ),
        level = level
    )

    fun Regex.match(
        vararg matches: Pair<Int, T?>,
        level: Int? = null,
    ) = addScheme(
        regex = this,
        match = Match.all(*matches),
        level = level
    )

    fun Regex.fully(
        value: T,
        level: Int? = null,
    ) = addScheme(
        regex = this,
        match = Match.fully(value),
        level = level
    )

    fun Regex.groups(
        vararg groups: T?,
        level: Int? = null,
    ) = addScheme(
        regex = this,
        match = Match.groups(*groups),
        level = level
    )
}