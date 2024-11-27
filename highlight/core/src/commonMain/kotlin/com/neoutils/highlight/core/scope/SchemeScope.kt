package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.Scope
import com.neoutils.highlight.core.util.Matcher

abstract class SchemeScope<T : Any, S : Scheme<*>> : Scope<S>() {

    protected abstract fun addScheme(
        regex: Regex,
        matcher: Matcher<T>,
        range: IntRange?
    )

    fun Regex.match(
        range: IntRange? = null,
        scope: MutableMap<Int, T>.() -> Unit
    ) = addScheme(
        regex = this,
        matcher = Matcher(
            matches = buildMap(scope)
        ),
        range = range
    )

    fun Regex.match(
        vararg matches: Pair<Int, T>,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.all(*matches),
        range = range
    )

    fun Regex.fully(
        value: T,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.fully(value),
        range = range
    )

    fun Regex.groups(
        vararg groups: T,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.groups(*groups),
        range = range
    )
}