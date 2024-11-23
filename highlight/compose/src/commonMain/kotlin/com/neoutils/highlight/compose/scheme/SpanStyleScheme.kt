package com.neoutils.highlight.compose.scheme

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Match

class SpanStyleScheme(
    override val regex: Regex,
    override val match: Match<SpanStyle>,
    override val level: Int = 0,
    override val tag: String = "span_style_scheme",
) : Scheme<SpanStyle>