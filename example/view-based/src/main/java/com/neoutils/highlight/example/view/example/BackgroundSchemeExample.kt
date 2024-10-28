package com.neoutils.highlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.highlight
import com.neoutils.highlight.view.extension.backgroundColor
import com.neoutils.highlight.view.extension.textColor
import com.neoutils.highlight.view.extension.toSpannedString

class BackgroundSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    context,
    attr
) {

    init {

        text = highlight {
            backgroundColor {
                fully(
                    regex = "color",
                    UiColor.Blue
                )
            }
            textColor {
                fully(
                    regex = "color",
                    UiColor.White
                )
            }
        }.toSpannedString(
            text = "Example of background color."
        )
    }
}
