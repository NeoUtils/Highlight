package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.StyleTextScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiStyle
import com.neoutils.highlight.view.extension.toSpannedString

class StyleSchemeExample(
    content: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    content,
    attr
) {

    init {
        text = Highlight(
            StyleTextScheme(
                regex = "style".toRegex(),
                values = Match.full(
                    UiStyle(UiStyle.Style.BOLD)
                )
            )
        ).toSpannedString(
            text = "Example of style."
        )
    }
}
