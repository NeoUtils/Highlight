package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.remember.rememberAnnotatedString
import com.neoutils.highlight.compose.remember.rememberHighlight
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.utils.UiColor

@Composable
fun CaptureGroupsExample() {

    val annotatedString = rememberHighlight {
        textColor {
            groups(
                regex = "(\"\\w+\")\\s*=\\s*(\"\\w+\")",
                UiColor.Blue,
                UiColor.Green
            )
        }
    }.rememberAnnotatedString(
        text = "\"name\" = \"Irineu\""
    )

    Text(text = annotatedString)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CaptureGroupsExample()
}