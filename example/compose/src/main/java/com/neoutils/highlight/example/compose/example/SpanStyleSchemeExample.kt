package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.spanStyle
import com.neoutils.highlight.compose.remember.rememberHighlightedString

@Composable
fun SpanStyleSchemeExample() {

    val highlighted = rememberHighlightedString(
        text = "Example of styled text."
    ) {
        spanStyle {
            fully(
                regex = "(styled)",
                SpanStyle(
                    color = Color.White,
                    background = Color.Black,
                    fontStyle = FontStyle.Italic,
                    textDecoration = TextDecoration.LineThrough,
                )
            )
        }
    }

    Text(text = highlighted)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SpanStyleSchemeExample()
}