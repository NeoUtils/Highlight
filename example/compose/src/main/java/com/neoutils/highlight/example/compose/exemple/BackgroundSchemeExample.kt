package com.neoutils.highlight.example.compose.exemple

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor

@Composable
fun BackgroundScreenExample() {

    val text = remember {
        Highlight(
            BackgroundColorScheme(
                regex = "background color".toRegex(),
                values = Match.full(
                    UiColor.Blue
                )
            ),
            TextColorScheme(
                regex = "background color".toRegex(),
                values = Match.full(
                    UiColor.White
                )
            )
        ).toAnnotatedString(
            text = "Example of background color."
        )
    }

    Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    BackgroundScreenExample()
}