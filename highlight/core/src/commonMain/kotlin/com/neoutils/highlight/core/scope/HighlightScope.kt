package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.Match
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.Scope
import com.neoutils.highlight.core.scheme.ScriptScheme
import com.neoutils.highlight.core.util.Matcher

class HighlightScope internal constructor() : Scope<Scheme<*>>() {

    // TODO(improve): Extract when to launch Context Parameters
    fun Regex.script(
        range: IntRange? = null,
        scope: HighlightScope.(Match) -> Unit
    ) {
        addScheme(
            ScriptScheme(
                regex = this,
                matcher = Matcher.fully(scope),
                range = range
            )
        )
    }
}
