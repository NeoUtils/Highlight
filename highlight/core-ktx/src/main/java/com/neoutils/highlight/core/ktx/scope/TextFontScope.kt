package com.neoutils.highlight.core.ktx.scope

import com.neoutils.highlight.core.scheme.TextFontScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiFont

class TextFontScope internal constructor() : SchemeScope<UiFont>() {

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