package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.extension.highlight
import com.neoutils.highlight.core.utils.UiColor
import com.neoutils.highlight.view.extension.toSpannedString

class CaptureGroupsExample(
    context: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    context,
    attr
) {
    init {
        text = highlight {
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