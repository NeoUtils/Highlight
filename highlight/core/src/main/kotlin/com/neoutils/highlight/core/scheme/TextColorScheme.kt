package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.utils.UiColor

data class TextColorScheme(
    override val regex: Regex,
    override val values: List<UiColor?>,
) : Scheme<UiColor>
