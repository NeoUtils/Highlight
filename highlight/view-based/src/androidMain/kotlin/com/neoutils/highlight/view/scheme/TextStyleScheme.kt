package com.neoutils.highlight.view.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.view.util.UiStyle

data class TextStyleScheme(
    override val regex: Regex,
    override val match: Match<UiStyle>,
    override val level: Int = 0,
    override val tag: String = "text_style_scheme",
) : Scheme<UiStyle>