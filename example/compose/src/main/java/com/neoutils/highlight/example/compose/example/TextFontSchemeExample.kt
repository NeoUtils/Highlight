package com.neoutils.highlight.example.compose.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.res.ResourcesCompat
import com.neoutils.highlight.compose.extension.toAnnotatedString
import com.neoutils.highlight.core.extension.highlight
import com.neoutils.highlight.core.utils.UiFont
import com.neoutils.highlight.example.compose.R

@Composable
fun TextFontSchemeExample() {

    val context = LocalContext.current

    val text = remember {
        highlight {
            textFont {
                fully(
                    regex = "font",
                    UiFont(
                        checkNotNull(
                            ResourcesCompat.getFont(
                                context,
                                R.font.pacifico_regular
                            )
                        )
                    )
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