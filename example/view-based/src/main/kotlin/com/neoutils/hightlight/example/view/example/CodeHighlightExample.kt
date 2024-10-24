package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.neoutils.highlight.core.extension.highlight
import com.neoutils.highlight.view.extension.textColor
import com.neoutils.highlight.view.text.LinesHighlightTextWatcher
import com.neoutils.highlight.view.util.UiColor

private val CodeHighlight = highlight {
    textColor {
        fully(
            regex = "\\b(fun)\\b",
            UiColor.hex(hex = "#0033B3")
        )

        groups(
            regex = "\\b(fun)\\b\\s*\\b(\\w+)\\b\\([^()]*\\)",
            UiColor.hex(hex = "#0033B3"),
            UiColor.hex(hex = "#00627A")
        )

        fully(
            regex = "@.+",
            UiColor.hex(hex = "#93880D")
        )

        fully(
            regex = "\"[^\"]*\"",
            UiColor.hex(hex = "#067D17")
        )
    }
}

class CodeHighlightExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatEditText(
    context,
    attr
) {
    init {
        addTextChangedListener(
            LinesHighlightTextWatcher(
                CodeHighlight,
                viewModifiedLines = true
            )
        )
    }
}