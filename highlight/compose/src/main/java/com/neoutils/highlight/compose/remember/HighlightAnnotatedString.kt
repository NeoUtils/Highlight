package com.neoutils.highlight.compose.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.scope.HighlightScope

@Composable
fun rememberHighlightedString(
    text: String,
    scope: HighlightScope.() -> Unit
): AnnotatedString {
    val highlight = rememberHighlight(scope)

    return remember { highlight.toAnnotatedString(text) }
}