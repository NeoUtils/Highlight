package com.neoutils.highlight.view.scope

import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.view.scheme.TextColorScheme
import com.neoutils.highlight.view.util.UiColor

class TextColorScope internal constructor(
    val schemes: MutableList<TextColorScheme> = mutableListOf()
) : SchemeScope<UiColor>() {

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