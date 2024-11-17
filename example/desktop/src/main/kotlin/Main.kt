import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
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
import com.neoutils.highlight.core.utils.UiColor

@Composable
@Preview
fun App() {
    var textFieldValue by remember {
        mutableStateOf(TextFieldValue("Hello, World!"))
    }

    BasicTextField(
        value = rememberHighlight {
            textColor {
                fully(
                    regex = "[A-Z][a-z]+",
                    UiColor.Blue
                )
                fully(
                    regex = "\\W",
                    UiColor.Red
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
        modifier = Modifier.fillMaxSize()
    )
}

fun main() = application {
    Window(
        title = "Desktop example",
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            width = 400.dp,
            height = 300.dp
        )
    ) {
        App()
    }
}
