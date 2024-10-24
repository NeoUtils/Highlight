package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.textColor
import com.neoutils.highlight.compose.remember.rememberHighlightedString

@Composable
fun CaptureGroupsExample() {

    val highlighted = rememberHighlightedString(
        text = "\"name\" = \"Irineu\""
    ) {
        textColor {
            groups(
                regex = "(\"\\w+\")\\s*=\\s*(\"\\w+\")",
                Color.Blue,
                Color.Green
            )
        }
    }

    Text(text = highlighted)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CaptureGroupsExample()
}