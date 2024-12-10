package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.Scope
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex

abstract class SchemeScope<T : Any, S : Scheme<*>> : Scope<S>() {

    protected abstract fun addScheme(
        regex: XRegex,
        matcher: Matcher<T>,
        range: IntRange? = null
    )

    fun XRegex.match(
        range: IntRange? = null,
        scope: MutableMap<Int, T>.() -> Unit
    ) = addScheme(
        regex = this,
        matcher = Matcher(
            matches = buildMap(scope)
        ),
        range = range
    )

    fun XRegex.match(
        vararg matches: Pair<Int, T>,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.all(*matches),
        range = range
    )

    fun XRegex.fully(
        value: T,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.fully(value),
        range = range
    )

    fun XRegex.groups(
        vararg groups: T,
        range: IntRange? = null,
    ) = addScheme(
        regex = this,
        matcher = Matcher.groups(*groups),
        range = range
    )
}