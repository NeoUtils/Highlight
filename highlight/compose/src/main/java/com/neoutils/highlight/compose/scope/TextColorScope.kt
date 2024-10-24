package com.neoutils.highlight.compose.scope

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match

class SpanStyleScope internal constructor(
    val schemes: MutableList<SpanStyleScheme> = mutableListOf()
) : SchemeScope<SpanStyle>() {

    override fun match(
        regex: String,
        match: Match<SpanStyle>
    ) {
        schemes.add(
            SpanStyleScheme(
                regex.toRegex(),
                match
            )
        )
    }
}