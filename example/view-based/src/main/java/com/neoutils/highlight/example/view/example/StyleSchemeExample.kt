package com.neoutils.highlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.view.extension.textStyle
import com.neoutils.highlight.view.extension.toSpannedString
import com.neoutils.highlight.view.util.UiStyle
import com.neoutils.xregex.extension.toXRegex

class StyleSchemeExample(
    content: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    content,
    attr
) {
    init {
        text = Highlight {
            textStyle {
                "\\bstyle\\b"
                    .toXRegex()
                    .fully(UiStyle.BOLD)
            }
        }.toSpannedString(
            text = "Example of style."
        )
    }
}
