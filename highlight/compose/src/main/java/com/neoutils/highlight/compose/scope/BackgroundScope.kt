package com.neoutils.highlight.compose.scope

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match

class BackgroundScope internal constructor() :
    SchemeScope<Color, SpanStyleScheme>() {

    override fun match(
        regex: String,
        match: Match<Color>
    ) {
        builder.add(
            SpanStyleScheme(
                regex = regex.toRegex(),
                match = Match(
                    match.values.map {
                        SpanStyle(
                            background = it ?: return@map null
                        )
                    }
                )
            )
        )
    }
}
