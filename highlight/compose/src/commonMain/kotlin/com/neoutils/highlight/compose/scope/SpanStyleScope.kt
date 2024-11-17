package com.neoutils.highlight.compose.scope

import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.util.Match

class SpanStyleScope internal constructor() :
    SchemeScope<SpanStyle, SpanStyleScheme>() {

    override fun match(
        regex: String,
        match: Match<SpanStyle>
    ) {
        builder.add(
            SpanStyleScheme(
                regex.toRegex(),
                match
            )
        )
    }
}
