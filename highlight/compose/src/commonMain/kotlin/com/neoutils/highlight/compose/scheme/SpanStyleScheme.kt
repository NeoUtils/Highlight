package com.neoutils.highlight.compose.scheme

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher

class SpanStyleScheme(
    override val regex: Regex,
    override val matcher: Matcher<SpanStyle>,
    override val range: IntRange?,
) : Scheme<SpanStyle>