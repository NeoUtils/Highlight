package com.neoutils.highlight.view.scope

import android.graphics.Typeface
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.view.scheme.TextFontScheme

class TextFontScope internal constructor() :
    SchemeScope<Typeface, TextFontScheme>() {

    override fun match(
        regex: String,
        match: Match<Typeface>
    ) {
        builder.add(
            TextFontScheme(
                regex.toRegex(),
                match
            )
        )
    }
}