package com.neoutils.highlight.example.compose.exemple

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neoutils.highlight.compose.remember.rememberHighlightTextField
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor
import org.intellij.lang.annotations.Language

private val CodeHighlight = Highlight(
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

@Language("kotlin")
private val code = """
    fun main() {
        print("Hello, World!")
    }
""".trimIndent()

@Composable
fun CodeHighlightExample(
    modifier: Modifier = Modifier
) {

    val highlight = rememberHighlightTextField {
        CodeHighlight
    }

    LaunchedEffect(Unit) {
        highlight.onChangeValue(
            TextFieldValue(
                text = code
            )
        )
    }

    BasicTextField(
        modifier = modifier,
        value = highlight.value.copy(
            composition = null
        ),
        onValueChange = {
            highlight.onChangeValue(it)
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