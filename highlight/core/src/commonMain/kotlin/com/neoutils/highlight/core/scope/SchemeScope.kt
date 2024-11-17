package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.Scope
import com.neoutils.highlight.core.util.Match

abstract class SchemeScope<T : Any, S : Scheme<*>> : Scope<S>() {

    abstract fun match(
        regex: Regex,
        match: Match<T>
    )

    fun fully(
        regex: Regex,
        value: T
    ) = match(
        regex = regex,
        match = Match.fully(value)
    )

    fun groups(
        regex: Regex,
        groups: List<T?>
    ) = match(
        regex = regex,
        match = Match.groups(groups)
    )

    fun groups(
        regex: Regex,
        vararg groups: T?
    ) = match(
        regex = regex,
        match = Match.groups(*groups)
    )
}