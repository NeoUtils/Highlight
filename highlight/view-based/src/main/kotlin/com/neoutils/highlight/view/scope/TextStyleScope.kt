package com.neoutils.highlight.view.scope

import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.view.scheme.TextStyleScheme
import com.neoutils.highlight.view.util.UiStyle

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