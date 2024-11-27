package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.util.Matcher
import com.neoutils.highlight.core.util.UiColor

class BackgroundColorScope internal constructor() :
    SchemeScope<UiColor, BackgroundColorScheme>() {

    override fun addScheme(
        regex: Regex,
        matcher: Matcher<UiColor>,
        range: IntRange?
    ) {
        builder.add(
            BackgroundColorScheme(
                regex = regex,
                matcher = matcher,
                range = range
            )
        )
    }
}