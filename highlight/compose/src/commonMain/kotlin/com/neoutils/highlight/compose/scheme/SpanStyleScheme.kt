package com.neoutils.highlight.compose.scheme

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Match

/**
 * Only supported in compose.
 */
class SpanStyleScheme(
    override val regex: Regex,
    override val match: Match<SpanStyle>
) : Scheme<SpanStyle>