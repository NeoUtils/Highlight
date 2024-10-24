package com.neoutils.highlight.compose.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.neoutils.highlight.core.extension.highlight
import com.neoutils.highlight.core.scope.HighlightScope

@Composable
fun rememberHighlight(
    scope: HighlightScope.() -> Unit
) = remember { highlight(scope) }
