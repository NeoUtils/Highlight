package com.neoutils.highlight.view.scheme

import android.text.ParcelableSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Match

data class SpanScheme(
    override val regex: Regex,
    override val match: Match<ParcelableSpan>,
    override val tag: String = "span_scheme",
) : Scheme<ParcelableSpan>