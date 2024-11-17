package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.core.util.UiColor

class TextColorScope internal constructor() :
    SchemeScope<UiColor, TextColorScheme>() {

    override fun match(
        regex: String,
        match: Match<UiColor>
    ) {
        builder.add(
            TextColorScheme(
                regex.toRegex(),
                match
            )
        )
    }
}