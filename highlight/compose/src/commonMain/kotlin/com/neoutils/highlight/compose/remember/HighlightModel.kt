package com.neoutils.highlight.compose.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.Highlight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class HighlightModel internal constructor() {

    internal val scope = CoroutineScope(context = SupervisorJob() + Dispatchers.Main.immediate)

    internal val highlight = MutableStateFlow(Highlight())

    private val textFieldValue = MutableStateFlow(TextFieldValue())

    val state = combine(
        highlight,
        textFieldValue
    ) { highlight, value ->
        value.copy(
            annotatedString = highlight.toAnnotatedString(
                value.text
            )
        )
    }.stateIn(
        scope = scope,
        initialValue = textFieldValue.value,
        started = SharingStarted.WhileSubscribed()
    )

    fun onChangeValue(value: TextFieldValue) {
        textFieldValue.value = value
    }
}

@Composable
fun rememberHighlightModel(
    highlight: Highlight
): HighlightModel {

    val highlightModel = remember {
        HighlightModel()
    }

    LaunchedEffect(highlight) {
        highlightModel.highlight.value = highlight
    }

    DisposableEffect(Unit) {
        onDispose {
            highlightModel.scope.cancel()
        }
    }

    return highlightModel
}