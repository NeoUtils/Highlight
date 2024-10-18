package com.neoutils.highlight.example.compose.exemple

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.extension.highlight

@Composable
fun TextColorSchemeExample() {

    val text = remember {
        highlight {
            textColor {
                fully(
                    regex = "foreground color",
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