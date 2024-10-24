package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.utils.Match
import org.intellij.lang.annotations.Language

abstract class SchemeScope<T : Any> internal constructor(
    internal val schemes: MutableList<Scheme<T>> = mutableListOf()
) {

    abstract fun match(
        @Language("RegExp") regex: String,
        match: Match<T>
    )

    fun fully(
        @Language("RegExp") regex: String,
        value: T
    ) = match(
        regex = regex,
        match = Match.fully(value)
    )

    fun groups(
        @Language("RegExp") regex: String,
        groups: List<T?>
    ) = match(
        regex = regex,
        match = Match.groups(groups)
    )

    fun groups(
        @Language("RegExp") regex: String,
        vararg groups: T?
    ) = match(
        regex = regex,
        match = Match.groups(*groups)
    )
}