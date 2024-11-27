package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.Scope
import com.neoutils.highlight.core.util.Matcher

abstract class SchemeScope<T : Any, S : Scheme<*>> : Scope<S>() {

    protected abstract fun addScheme(
        regex: Regex,
        matcher: Matcher<T>,
    )

    fun Regex.match(
        scope: MutableMap<Int, T>.() -> Unit
    ) = addScheme(
        regex = this,
        matcher = Matcher(
            matches = buildMap(scope)
        ),
    )

    fun Regex.match(
        vararg matches: Pair<Int, T>,
    ) = addScheme(
        regex = this,
        matcher = Matcher.all(*matches),
    )

    fun Regex.fully(
        value: T,
    ) = addScheme(
        regex = this,
        matcher = Matcher.fully(value),
    )

    fun Regex.groups(
        vararg groups: T,
    ) = addScheme(
        regex = this,
        matcher = Matcher.groups(*groups),
    )
}