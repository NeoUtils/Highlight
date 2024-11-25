package com.neoutils.highlight.view.scope

import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.view.scheme.TextStyleScheme
import com.neoutils.highlight.view.util.UiStyle

class TextStyleScope internal constructor() :
    SchemeScope<UiStyle, TextStyleScheme>() {

    override fun addScheme(
        regex: Regex,
        match: Match<UiStyle>,
        level: Int?
    ) {
        builder.add(
            TextStyleScheme(
                regex = regex,
                match = match,
                level = level
            )
        )
    }
}