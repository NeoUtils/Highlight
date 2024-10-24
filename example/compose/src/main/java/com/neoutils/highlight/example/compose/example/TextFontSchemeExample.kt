package com.neoutils.highlight.example.compose.exemple

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.ktx.highlight
import com.neoutils.highlight.core.utils.UiFont
import com.neoutils.highlight.example.compose.R

@Composable
fun TextFontSchemeExample() {
    
    val text = remember {
        highlight {
            textFont {
                fully(
                    regex = "font",
                    UiFont(R.font.pacifico_regular)
                )
            }
        }.toAnnotatedString(
            text = "Example of font style."
        )
    }

    Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    TextFontSchemeExample()
}