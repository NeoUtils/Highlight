package com.neoutils.highlight.view.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.view.util.UiStyle

data class TextStyleScheme(
    override val regex: Regex,
    override val matcher: Matcher<UiStyle>,
    override val range: IntRange? = null,
) : Scheme<UiStyle>