package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.ktx.highlight
import com.neoutils.highlight.core.utils.UiColor

@Composable
fun BackgroundSchemeExample() {

    val text = remember {
        highlight {
            backgroundColor {
                fully(
                    regex = "color",
                    value = UiColor.Blue
                )
            }

            textColor {
                fully(
                    regex = "color",
                    value = UiColor.White
                )
            }
        }.toAnnotatedString(
            text = "Example of background color."
        )
    }

    Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    BackgroundSchemeExample()
}