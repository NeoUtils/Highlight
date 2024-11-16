package com.neoutils.highlight.example.compose.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neoutils.highlight.compose.remember.rememberHighlight
import com.neoutils.highlight.compose.remember.rememberTextFieldValue
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.utils.UiColor
import org.intellij.lang.annotations.Language

@Language("kotlin")
private val code = """
    fun main() {
        print("Hello, World!")
    }
""".trimIndent()

@Composable
fun CodeHighlightExample() {

    var highlightEnabled by rememberSaveable { mutableStateOf(true) }

    val highlight = rememberHighlight(highlightEnabled) {
        if (highlightEnabled) {
            textColor {
                fully(
                    regex = "\\b(fun)\\b",
                    UiColor.Hex(hex = "#0033B3")
                )

                groups(
                    regex = "\\b(fun)\\b\\s*\\b(\\w+)\\b\\([^()]*\\)",
                    UiColor.Hex(hex = "#0033B3"),
                    UiColor.Hex(hex = "#00627A")
                )

                fully(
                    regex = "@.+",
                    UiColor.Hex(hex = "#93880D")
                )

                fully(
                    regex = "\"[^\"]*\"",
                    UiColor.Hex(hex = "#067D17")
                )
            }
        }
    }

    val textFieldValue = rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) {
        mutableStateOf(TextFieldValue(code))
    }

    BasicTextField(
        modifier = Modifier,
        value = highlight.rememberTextFieldValue(
            value = textFieldValue.value.copy(
                composition = null
            )
        ),
        onValueChange = {
            textFieldValue.value = it
        },
        decorationBox = {
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                it()

                Button(
                    onClick = {
                        highlightEnabled = !highlightEnabled
                    }
                ) {
                    if (highlightEnabled) {
                        Text(text = "OFF")
                    } else {
                        Text(text = "ON")
                    }
                }
            }
        },
        textStyle = TextStyle(
            fontSize = 16.sp
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CodeHighlightExample()
}