import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.neoutils.highlight.compose.extension.spanStyle
import com.neoutils.highlight.compose.remember.rememberHighlight
import com.neoutils.highlight.compose.remember.rememberTextFieldValue
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.core.util.UiColor

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
                    regex = "[A-Z][a-z]+".toRegex(),
                    UiColor.Blue
                )
                fully(
                    regex = "\\W".toRegex(),
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
