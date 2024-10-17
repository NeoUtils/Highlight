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

@Composable
fun CaptureGroupsExample() {

    val text = remember {
        Highlight(
            TextColorScheme(
                regex = "(\"\\w+\")\\s*=\\s*(\"\\w+\")".toRegex(),
                match = Match.groups(
                    UiColor.Blue,
                    UiColor.Green
                )
            ),
        ).toAnnotatedString(
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