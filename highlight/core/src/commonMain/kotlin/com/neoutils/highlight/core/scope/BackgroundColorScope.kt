package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.BackgroundColorScheme
import com.neoutils.highlight.core.utils.UiColor

class BackgroundColorScope internal constructor() :
    SchemeScope<UiColor, BackgroundColorScheme>() {

    override fun match(
        regex: String,
        match: Match<UiColor>
    ) {
        builder.add(
            BackgroundColorScheme(
                regex.toRegex(),
                match
            )
        )
    }
}