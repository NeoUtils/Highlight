package com.neoutils.highlight.example.compose.exemple

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.intellij.lang.annotations.Language

private class CodeHighlight {

    private val _text = MutableStateFlow(TextFieldValue())
    val text = _text.asStateFlow()

    private val highlight = Highlight(
        TextColorScheme(
            regex = "\\b(fun)\\b".toRegex(),
            values = Match.full(
                UiColor.Hex(hex = "#0033B3")
            )
        ),
        TextColorScheme(
            regex = "\\b(fun)\\b\\s*\\b(\\w+)\\b\\([^()]*\\)".toRegex(),
            values = Match.group(
                UiColor.Hex(hex = "#0033B3"),
                UiColor.Hex(hex = "#00627A")
            )
        ),
        TextColorScheme(
            regex = "@.+".toRegex(),
            values = Match.full(
                UiColor.Hex(hex = "#93880D")
            )
        ),
        TextColorScheme(
            regex = "\"[^\"]*\"".toRegex(),
            values = Match.full(
                UiColor.Hex(hex = "#067D17")
            )
        )
    )

    init {

        @Language("kotlin")
        val code = """
            fun main() {
                println("Hello, World!")
            }
        """.trimIndent()

        onChangeText(
            TextFieldValue(
                text = code
            )
        )
    }

    fun onChangeText(value: TextFieldValue) {
        _text.value = value.copy(
            annotatedString = highlight.toAnnotatedString(
                value.text
            )
        )
    }
}

@Composable
fun CodeHighlightExample(
    modifier: Modifier = Modifier
) {

    val viewModel = remember { CodeHighlight() }

    val value = viewModel.text.collectAsState().value
    
    BasicTextField(
        modifier = modifier,
        value = value.copy(
            composition = null
        ),
        onValueChange = {
            viewModel.onChangeText(it)
        },
        decorationBox = {
            Box(Modifier.padding(8.dp)) {
                it()
            }
        },
        textStyle = TextStyle(
            fontSize = 16.sp
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CodeHighlightExample()
}