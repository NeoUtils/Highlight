package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.view.extension.toSpannedString

class BackgroundSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    context,
    attr
) {

    init {
        text = Highlight(
            BackgroundColorScheme(
                regex = "background color".toRegex(),
                values = Match.full(
                    UiColor.Blue
                )
            ),
            TextColorScheme(
                regex = "background color".toRegex(),
                values = Match.full(
                    UiColor.White
                )
            )
        ).toSpannedString(
            text = "Example of background color."
        )
    }
}
