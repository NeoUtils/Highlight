package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.scheme.TextColorScheme
import com.neoutils.highlight.core.utils.Match
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.view.extension.toSpannedString

class TextColorSchemeExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(context, attr) {

    init {

        text = Highlight(
            TextColorScheme(
                regex = Regex(pattern = "foreground color"),
                match = Match.fully(
                    UiColor.Blue
                )
            )
        ).toSpannedString(
            text = "Example of foreground color."
        )
    }
}
