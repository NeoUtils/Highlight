package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Match
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scope.HighlightScope
import com.neoutils.highlight.core.util.Matcher

typealias Script = HighlightScope.(Match) -> Unit

class ScriptScheme(
    override val regex: Regex,
    override val matcher: Matcher<Script>,
    override val range: IntRange?,
) : Scheme<Script> {

    init {
        check(matcher.matches.size == 1)
    }
}