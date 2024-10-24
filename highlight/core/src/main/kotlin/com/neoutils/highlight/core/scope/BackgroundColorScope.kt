package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor

class BackgroundColorScope internal constructor() : SchemeScope<UiColor>() {

    override fun match(
        regex: String,
        match: Match<UiColor>
    ) {
        schemes.add(
            BackgroundColorScheme(
                regex.toRegex(),
                match
            )
        )
    }
}