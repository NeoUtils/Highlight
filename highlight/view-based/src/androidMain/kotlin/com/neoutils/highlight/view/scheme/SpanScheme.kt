package com.neoutils.highlight.view.scheme

import android.text.ParcelableSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex

data class SpanScheme(
    override val regex: XRegex,
    override val matcher: Matcher<ParcelableSpan>,
    override val range: IntRange? = null,
) : Scheme<ParcelableSpan>