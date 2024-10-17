package com.neoutils.highlight.compose.remember

import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.Highlight

data class HighlightTextField(
    private val highlight: Highlight
) {

    var value by mutableStateOf(TextFieldValue())
        private set

    fun onChangeValue(value: TextFieldValue) {
        this.value = value.copy(
            annotatedString = highlight.toAnnotatedString(
                value.text
            )
        )
    }

}

@Composable
fun rememberHighlightTextField(
    vararg key: Any,
    block: () -> Highlight
): HighlightTextField {

    return remember(*key) {
        HighlightTextField(block())
    }
}