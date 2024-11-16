package com.neoutils.highlight.example.compose.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neoutils.highlight.compose.remember.rememberHighlightModel
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.example.compose.R
import com.neoutils.highlight.example.compose.theme.ExampleTheme
import org.intellij.lang.annotations.Language

@OptIn(ExperimentalMaterial3Api::class)
class CodeHighlightExample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExampleTheme {

                val highlightEnabled = remember { mutableStateOf(true) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(R.string.app_name))
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = colorScheme.primary,
                                titleContentColor = colorScheme.onPrimary
                            )
                        )
                    },
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
                            Box(Modifier.padding(16.dp)) {
                                it()
                            }
                        },
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(
                                Font(R.font.jetbrains_mono)
                            ),
                            letterSpacing = 0.sp,
                        ),
                    )
                }
            }
        }
    }
}

private val CodeHighlight = Highlight {
    textColor {
        fully(
            regex = "\\b(fun)\\b",
            UiColor.Hex(hex = "#E66123")
        )

        groups(
            regex = "\\b(\\w+)\\b\\((\\w+\\s*=)?[^)]*\\)",
            UiColor.Hex(hex = "#00627A"),
            UiColor.Hex(hex = "#548AF7"),
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

@Language("kotlin")
private val code = """
    @Composable
    fun App() {
        Text(text = "Hello, world!")
    }
""".trimIndent()
