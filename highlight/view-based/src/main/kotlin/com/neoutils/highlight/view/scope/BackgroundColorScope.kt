package com.neoutils.highlight.view.scope

import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.view.scheme.BackgroundColorScheme
import com.neoutils.highlight.view.util.UiColor

class BackgroundColorScope internal constructor(
    val schemes: MutableList<BackgroundColorScheme> = mutableListOf()
) : SchemeScope<UiColor>() {

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