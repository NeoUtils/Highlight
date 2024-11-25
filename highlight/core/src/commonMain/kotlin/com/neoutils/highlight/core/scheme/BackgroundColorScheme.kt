package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.core.util.UiColor

data class BackgroundColorScheme(
    override val regex: Regex,
    override val match: Match<UiColor>,
    override val level: Int? = null,
    override val tag: String = "background_color_scheme",
) : Scheme<UiColor>