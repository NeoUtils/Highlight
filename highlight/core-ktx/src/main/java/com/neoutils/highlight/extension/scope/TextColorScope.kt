package com.neoutils.highlight.extension.scope

import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor

class TextColorScope internal constructor() : SchemeScope<UiColor>() {

    override fun match(
        regex: String,
        match: Match<UiColor>
    ) {
        schemes.add(
            TextColorScheme(
                regex.toRegex(),
                match
            )
        )
    }
}