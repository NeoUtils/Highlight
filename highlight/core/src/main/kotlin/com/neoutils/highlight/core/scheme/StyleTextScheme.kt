package com.neoutils.highlight.core.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.utils.UiStyle

data class StyleTextScheme(
    override val regex: Regex,
    override val values: List<UiStyle?>,
) : Scheme<UiStyle>