package com.neoutils.hightlight.example.view.exemple

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.ForegroundColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.view.text.LinesHighlightTextWatcher

class CodeHighlightExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatEditText(
    context,
    attr
) {
    init {

        val highlight = Highlight(
            ForegroundColorScheme(
                regex = "\\b(fun)\\b".toRegex(),
                values = Match.full(
                    UiColor.Hex(hex = "#0033B3")
                )
            ),
            ForegroundColorScheme(
                regex = "\\b(fun)\\b\\s*\\b(\\w+)\\b\\([^()]*\\)".toRegex(),
                values = Match.group(
                    UiColor.Hex(hex = "#0033B3"),
                    UiColor.Hex(hex = "#00627A")
                )
            ),
            ForegroundColorScheme(
                regex = "@.+".toRegex(),
                values = Match.full(
                    UiColor.Hex(hex = "#93880D")
                )
            ),
            ForegroundColorScheme(
                regex = "\"[^\"]*\"".toRegex(),
                values = Match.full(
                    UiColor.Hex(hex = "#067D17")
                )
            )
        )

        addTextChangedListener(
            LinesHighlightTextWatcher(
                highlight,
                viewModifiedLines = true
            )
        )
    }
}