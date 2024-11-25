package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.core.util.UiColor

data class TextColorScheme(
    override val regex: Regex,
    override val match: Match<UiColor>,
    override val tag: String = "text_color_scheme"
) : Scheme<UiColor>