package com.neoutils.highlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.core.util.UiColor
import com.neoutils.highlight.view.extension.toSpannedString

class CaptureGroupsExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    context,
    attr
) {
    init {
        text = Highlight {
            textColor {
                groups(
                    regex = "(\"\\w+\")\\s*=\\s*(\"\\w+\")",
                    UiColor.Blue,
                    UiColor.Green
                )
            }
        }.toSpannedString(
            text = "\"name\" = \"Irineu\""
        )
    }
}