package com.neoutils.highlight.view.scheme

import android.text.ParcelableSpan
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher

data class SpanScheme(
    override val regex: Regex,
    override val matcher: Matcher<ParcelableSpan>,
) : Scheme<ParcelableSpan>