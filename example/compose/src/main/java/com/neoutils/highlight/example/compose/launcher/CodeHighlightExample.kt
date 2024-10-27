package com.neoutils.highlight.example.compose.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neoutils.highlight.compose.extension.invoke
import com.neoutils.highlight.compose.extension.textColor
import com.neoutils.highlight.compose.remember.rememberHighlightModel
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.highlight
import com.neoutils.highlight.example.compose.theme.HighlightTheme
import org.intellij.lang.annotations.Language

class CodeHighlightExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HighlightTheme(darkTheme = false) {

                val highlightEnabled = remember { mutableStateOf(true) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                highlightEnabled.value = !highlightEnabled.value
                            }
                        ) {
                            if (highlightEnabled.value) {
                                Text(text = "OFF")
                            } else {
                                Text(text = "ON")
                            }
                        }
                    }
                ) { innerPadding ->

                    val highlightModel = rememberHighlightModel(
                        if (highlightEnabled.value) {
                            CodeHighlight
                        } else {
                            Highlight()
                        }
                    )

                    val textFieldValue by highlightModel.state.collectAsState()

                    LaunchedEffect(Unit) {
                        highlightModel.onChangeValue(
                            TextFieldValue(code)
                        )
                    }

                    BasicTextField(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        value = textFieldValue.copy(
                            composition = null
                        ),
                        onValueChange = {
                            highlightModel.onChangeValue(it)
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
            }
        }
    }
}

private val CodeHighlight = highlight {
    textColor {
        fully(
            regex = "\\b(fun)\\b",
            Color(hex = "#0033B3")
        )

        groups(
            regex = "\\b(fun)\\b\\s*\\b(\\w+)\\b\\([^()]*\\)",
            Color(hex = "#0033B3"),
            Color(hex = "#00627A")
        )

        fully(
            regex = "@.+",
            Color(hex = "#93880D")
        )

        fully(
            regex = "\"[^\"]*\"",
            Color(hex = "#067D17")
        )
    }
}

@Language("kotlin")
private val code = """
    fun main() {
        print("Hello, World!")
    }
""".trimIndent()
