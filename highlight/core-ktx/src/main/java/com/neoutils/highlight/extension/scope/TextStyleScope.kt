package com.neoutils.highlight.extension.scope

import com.neoutils.highlight.core.scheme.TextStyleScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiStyle

class TextStyleScope internal constructor() : SchemeScope<UiStyle>() {

    override fun match(
        regex: String,
        match: Match<UiStyle>
    ) {
        schemes.add(
            TextStyleScheme(
                regex.toRegex(),
                match
            )
        )
    }
}