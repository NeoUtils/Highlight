package com.neoutils.hightlight.example.view.exemple

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.ForegroundColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.view.extension.toSpannedString

class ForegroundColorSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(context, attr) {

    init {

        text = Highlight(
            ForegroundColorScheme(
                regex = Regex(pattern = "foreground color"),
                values = Match.full(
                    UiColor.Blue
                )
            )
        ).toSpannedString(
            text = "Example of foreground color."
        )
    }
}
