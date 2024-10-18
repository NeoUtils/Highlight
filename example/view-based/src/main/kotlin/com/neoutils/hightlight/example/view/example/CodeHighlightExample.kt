package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.extension.highlight
import com.neoutils.highlight.view.text.LinesHighlightTextWatcher

private val CodeHighlight = highlight {
    textColor {
        fully(
            regex = "\\b(fun)\\b",
            UiColor.Hex(hex = "#0033B3")
        )

        groups(
            regex = "\\b(fun)\\b\\s*\\b(\\w+)\\b\\([^()]*\\)",
            UiColor.Hex(hex = "#0033B3"),
            UiColor.Hex(hex = "#00627A")
        )

        fully(
            regex = "@.+",
            UiColor.Hex(hex = "#93880D")
        )

        fully(
            regex = "\"[^\"]*\"",
            UiColor.Hex(hex = "#067D17")
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