package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.spanStyle
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.extension.highlight

@Composable
fun CaptureGroupsExample() {

    val text = remember {
        highlight {
            spanStyle {
                groups(
                    regex = "(\"\\w+\")\\s*=\\s*(\"\\w+\")",
                    SpanStyle(color = Color.Blue),
                    SpanStyle(color = Color.Green)
                )
            }
        }.toAnnotatedString(
            text = "\"name\" = \"Irineu\""
        )
    }

    Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CaptureGroupsExample()
}