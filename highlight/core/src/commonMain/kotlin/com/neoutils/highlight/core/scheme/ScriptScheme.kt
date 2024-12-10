package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Match
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.scope.HighlightScope
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.xRegex

typealias Script = HighlightScope.(Match) -> Unit

class ScriptScheme(
    override val regex: XRegex,
    override val matcher: Matcher<Script>,
    override val range: IntRange?,
) : Scheme<Script> {

    init {
        check(matcher.matches.size == 1)
    }

    constructor(
        regex: Regex,
        matcher: Matcher<Script>,
        range: IntRange? = null
    ) : this(
        regex = regex.xRegex(),
        matcher = matcher,
        range = range
    )
}