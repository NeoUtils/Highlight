package com.neoutils.highlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.highlight
import com.neoutils.highlight.view.extension.textColor
import com.neoutils.highlight.view.extension.toSpannedString

class TextColorSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(context, attr) {

    init {

        text = highlight {
            textColor {
                fully(
                    regex = "color",
                    value = UiColor.Blue
                )
            }
        }.toSpannedString(
            text = "Example of foreground color."
        )
    }
}
