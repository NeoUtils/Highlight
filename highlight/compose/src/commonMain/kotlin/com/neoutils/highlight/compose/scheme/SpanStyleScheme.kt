package com.neoutils.highlight.compose.scheme

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex

class SpanStyleScheme(
    override val regex: XRegex,
    override val matcher: Matcher<SpanStyle>,
    override val range: IntRange?,
) : Scheme<SpanStyle>