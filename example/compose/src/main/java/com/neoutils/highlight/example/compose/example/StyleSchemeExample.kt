package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.extension.highlight
import com.neoutils.highlight.core.utils.UiStyle

@Composable
fun StyleSchemeExample() {

    val text = remember {

        highlight {
            textStyle {
                fully(
                    regex = "style",
                    value = UiStyle(UiStyle.Style.BOLD)
                )
            }
        }.toAnnotatedString(
            text = "Example of style."
        )
    }

    Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    StyleSchemeExample()
}