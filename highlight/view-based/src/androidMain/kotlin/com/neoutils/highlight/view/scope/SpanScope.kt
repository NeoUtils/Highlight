package com.neoutils.highlight.view.scope

import android.text.ParcelableSpan
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.view.scheme.SpanScheme

class SpanScope internal constructor() :
    SchemeScope<ParcelableSpan, SpanScheme>() {

    override fun match(
        regex: String,
        match: Match<ParcelableSpan>
    ) {
        builder.add(
            SpanScheme(
                regex.toRegex(),
                match
            )
        )
    }
}