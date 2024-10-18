package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.ktx.highlight
import com.neoutils.highlight.core.utils.UiColor

@Composable
fun TextColorSchemeExample() {

    val text = remember {
        highlight {
            textColor {
                fully(
                    regex = "color",
                    UiColor.Blue
                )
            }
        }.toAnnotatedString(
            text = "Example of foreground color."
        )
    }

    Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    TextColorSchemeExample()
}