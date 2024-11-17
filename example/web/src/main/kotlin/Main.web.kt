import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.compose.remember.rememberHighlight
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.core.util.UiColor
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow(
            canvasElementId = "viewport-container",
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = rememberHighlight {
                        textColor {
                            match(
                                regex = "(\\w+),\\s*(\\w+)!".toRegex(),
                                match = Match(
                                    values = listOf(
                                        UiColor.Red,
                                        UiColor.Blue,
                                        UiColor.Green
                                    )
                                )
                            )
                        }
                    }.toAnnotatedString(text = "Hello, world!")
                )
            }
        }
    }
}
