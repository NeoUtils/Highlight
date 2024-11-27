package com.neoutils.highlight.core.scheme

import Match
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scope.HighlightScope
import com.neoutils.highlight.core.util.Matcher

typealias Script = HighlightScope.(Match) -> Unit

class ScriptScheme(
    override val regex: Regex,
    override val matcher: Matcher<Script>,
) : Scheme<Script> {

    init {
        check(matcher.matches.size == 1)
    }
}