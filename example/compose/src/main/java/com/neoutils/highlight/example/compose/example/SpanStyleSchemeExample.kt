package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.compose.scheme.SpanStyleScheme
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.utils.Match

@Composable
fun SpanStyleSchemeExample() {

    val text = remember {
        Highlight(
            SpanStyleScheme(
                regex = "(styled)".toRegex(),
                match = Match.fully(
                    SpanStyle(
                        color = Color.White,
                        background = Color.Black,
                        fontStyle = FontStyle.Italic,
                        textDecoration = TextDecoration.LineThrough
                    ),
                )
            )
        ).toAnnotatedString(
            text = "Example of styled text."
        )
    }

    Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SpanStyleSchemeExample()
}