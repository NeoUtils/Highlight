package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiStyle

data class TextStyleScheme(
    override val regex: Regex,
    override val match: Match<UiStyle>,
) : Scheme<UiStyle>