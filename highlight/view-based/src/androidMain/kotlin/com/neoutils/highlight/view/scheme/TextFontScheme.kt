package com.neoutils.highlight.view.scheme

import android.graphics.Typeface
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.xregex.XRegex

data class TextFontScheme(
    override val regex: XRegex,
    override val matcher: Matcher<Typeface>,
    override val range: IntRange? = null,
) : Scheme<Typeface>