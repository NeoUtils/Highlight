package com.neoutils.highlight.view.scheme

import com.neoutils.highlight.core.Scheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.view.util.UiFont

data class TextFontScheme(
    override val regex: Regex,
    override val match: Match<UiFont>,
) : Scheme<UiFont>