package com.neoutils.highlight.view.scope

import android.text.ParcelableSpan
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.view.scheme.SpanScheme

class SpanScope internal constructor() :
    SchemeScope<ParcelableSpan, SpanScheme>() {

    override fun addScheme(
        regex: Regex,
        match: Match<ParcelableSpan>,
        level: Int?
    ) {
        builder.add(
            SpanScheme(
                regex = regex,
                match = match,
                level = level
            )
        )
    }
}