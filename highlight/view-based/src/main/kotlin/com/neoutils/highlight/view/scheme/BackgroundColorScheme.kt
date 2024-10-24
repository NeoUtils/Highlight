package com.neoutils.highlight.view.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.view.util.UiColor

data class BackgroundColorScheme(
    override val regex: Regex,
    override val match: Match<UiColor>,
) : Scheme<UiColor>