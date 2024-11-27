package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.core.util.UiColor

data class BackgroundColorScheme(
    override val regex: Regex,
    override val matcher: Matcher<UiColor>,
    override val range: IntRange? = null,
) : Scheme<UiColor>