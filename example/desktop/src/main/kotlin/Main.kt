import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.neoutils.highlight.compose.remember.rememberHighlight
import com.neoutils.highlight.compose.remember.rememberTextFieldValue
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.util.UiColor

@Composable
@Preview
fun App() {
    var textFieldValue by remember {
        mutableStateOf(TextFieldValue("(\\w+)\\1"))
    }

    BasicTextField(
        value = rememberHighlight {
            """\([^\)]*\)"""
                .toRegex()
                .script { match ->
                    textColor {
                        """\\${match.index.inc()}"""
                            .toRegex()
                            .fully(UiColor.Blue)
                    }
                }

            textColor {
                """(\()[^\)]*(\))"""
                    .toRegex()
                    .groups(
                        UiColor.Green,
                        UiColor.Green,
                    )
            }
        }.rememberTextFieldValue(
            value = textFieldValue
        ),
        onValueChange = {
            textFieldValue = it
        },
        textStyle = TextStyle(
            fontSize = 16.sp
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    )
}

fun main() = application {
    Window(
        title = "Desktop example",
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            width = 600.dp,
            height = 400.dp
        )
    ) {
        App()
    }
}
