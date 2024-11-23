package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.core.util.UiColor

class BackgroundColorScope internal constructor() :
    SchemeScope<UiColor, BackgroundColorScheme>() {

    override fun addScheme(
        regex: Regex,
        match: Match<UiColor>,
        level: Int
    ) {
        builder.add(
            BackgroundColorScheme(
                regex = regex,
                match = match,
                level = level
            )
        )
    }
}