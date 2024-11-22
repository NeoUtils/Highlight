package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.Scope
import com.neoutils.highlight.core.util.Match

abstract class SchemeScope<T : Any, S : Scheme<*>> : Scope<S>() {

    protected abstract fun addScheme(
        regex: Regex,
        match: Match<T>
    )

    fun Regex.match(
        scope: MutableMap<Int, T>.() -> Unit
    ) = addScheme(
        regex = this,
        match = Match(
            matches = buildMap {
                scope(this)
            }
        )
    )

    fun Regex.match(
        vararg matches: Pair<Int, T>
    ) = addScheme(
        regex = this,
        match = Match.all(*matches)
    )

    fun Regex.fully(
        value: T
    ) = addScheme(
        regex = this,
        Match.fully(value)
    )

    fun Regex.groups(
        vararg groups: T?
    ) = addScheme(
        regex = this,
        Match.groups(*groups)
    )
}