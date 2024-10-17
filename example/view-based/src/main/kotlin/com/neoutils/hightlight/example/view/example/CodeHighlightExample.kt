package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.TextColorScheme
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
            TextColorScheme(
                regex = "\\b(fun)\\b".toRegex(),
                match = Match.fully(
                    UiColor.Hex(hex = "#0033B3")
                )
            ),
            TextColorScheme(
                regex = "\\b(fun)\\b\\s*\\b(\\w+)\\b\\([^()]*\\)".toRegex(),
                match = Match.groups(
                    UiColor.Hex(hex = "#0033B3"),
                    UiColor.Hex(hex = "#00627A")
                )
            ),
            TextColorScheme(
                regex = "@.+".toRegex(),
                match = Match.fully(
                    UiColor.Hex(hex = "#93880D")
                )
            ),
            TextColorScheme(
                regex = "\"[^\"]*\"".toRegex(),
                match = Match.fully(
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