package com.neoutils.highlight.compose.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scope.HighlightScope

@Composable
fun rememberHighlight(
    vararg keys: Any?,
    scope: HighlightScope.() -> Unit
) = remember(*keys) { Highlight(scope) }

@Composable
fun Highlight.rememberAnnotatedString(
    text: String,
) = remember(this, text) { toAnnotatedString(text) }

@Composable
fun Highlight.rememberTextFieldValue(
    value: TextFieldValue,
) = remember(this, value) {
    value.copy(toAnnotatedString(value.text))
}