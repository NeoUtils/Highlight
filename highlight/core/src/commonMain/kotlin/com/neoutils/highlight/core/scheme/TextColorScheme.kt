package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.xregex.XRegex

data class TextColorScheme(
    override val regex: XRegex,
    override val matcher: Matcher<UiColor>,
    override val range: IntRange? = null,
) : Scheme<UiColor>