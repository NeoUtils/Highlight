package com.neoutils.highlight.compose.extension

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.compose.scope.SpanStyleScope
import com.neoutils.highlight.core.scope.HighlightScope
import com.neoutils.highlight.core.scope.SchemeScope
import com.neoutils.highlight.core.utils.Match

fun HighlightScope.spanStyle(scope: SpanStyleScope.() -> Unit) {
    schemes.addAll(
        SpanStyleScope().apply(scope).schemes
    )
}

fun HighlightScope.textColor(scope: SchemeScope<Color>.() -> Unit) {

    object : SchemeScope<Color>() {
        override fun match(regex: String, match: Match<Color>) {
            schemes.add(
                SpanStyleScheme(
                    regex = regex.toRegex(),
                    match = Match(
                        match.values.map {
                            SpanStyle(
                                color = it ?: return@map null
                            )
                        }
                    )
                )
            )
        }
    }.apply(scope)
}

fun HighlightScope.backgroundColor(scope: SchemeScope<Color>.() -> Unit) {

    object : SchemeScope<Color>() {
        override fun match(regex: String, match: Match<Color>) {
            schemes.add(
                SpanStyleScheme(
                    regex = regex.toRegex(),
                    match = Match(
                        match.values.map {
                            SpanStyle(
                                background = it ?: return@map null
                            )
                        }
                    )
                )
            )
        }
    }.apply(scope)
}