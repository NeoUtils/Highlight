package com.neoutils.highlight.view.scope

import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.view.scheme.TextFontScheme
import com.neoutils.highlight.view.util.UiFont

class TextFontScope internal constructor(
    val schemes: MutableList<TextFontScheme> = mutableListOf()
) : SchemeScope<UiFont>() {

    override fun match(
        regex: String,
        match: Match<UiFont>
    ) {
        schemes.add(
            TextFontScheme(
                regex.toRegex(),
                match
            )
        )
    }
}