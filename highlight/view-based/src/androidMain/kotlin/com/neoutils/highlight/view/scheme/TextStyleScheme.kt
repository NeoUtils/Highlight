package com.neoutils.highlight.view.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.view.util.UiStyle

data class TextStyleScheme(
    override val regex: Regex,
    override val match: Match<UiStyle>,
) : Scheme<UiStyle>