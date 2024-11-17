package com.neoutils.highlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.highlight.view.text.LinesHighlightTextWatcher

private val CodeHighlight = Highlight {
    textColor {
        fully(
            regex = "\\b(fun)\\b".toRegex(),
            UiColor.Hex(hex = "#0033B3")
        )

        groups(
            regex = "\\b(fun)\\b\\s*\\b(\\w+)\\b\\([^()]*\\)".toRegex(),
            UiColor.Hex(hex = "#0033B3"),
            UiColor.Hex(hex = "#00627A")
        )

        fully(
            regex = "@.+".toRegex(),
            UiColor.Hex(hex = "#93880D")
        )

        fully(
            regex = "\"[^\"]*\"".toRegex(),
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