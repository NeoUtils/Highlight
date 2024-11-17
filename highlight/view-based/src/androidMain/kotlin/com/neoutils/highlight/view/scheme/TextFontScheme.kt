package com.neoutils.highlight.view.scheme

import android.graphics.Typeface
import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.util.Match

data class TextFontScheme(
    override val regex: Regex,
    override val match: Match<Typeface>,
) : Scheme<Typeface>