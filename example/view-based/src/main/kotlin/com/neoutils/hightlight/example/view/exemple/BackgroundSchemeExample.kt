package com.neoutils.hightlight.example.view.exemple

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.scheme.ForegroundColorScheme
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
            ForegroundColorScheme(
                "background color".toRegex(),
                Match.full(
                    UiColor.White
                )
            )
        ).toSpannedString("Example of background color.")
    }
}
