package com.neoutils.highlight.example.compose.exemple

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.TextStyleScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiStyle
import com.neoutils.highlight.extension.highlight

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