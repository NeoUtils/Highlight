package com.neoutils.highlight.view.text

import android.text.Editable
import android.text.TextWatcher
import com.neoutils.highlight.core.Highlight
import com.neoutils.highlight.view.extension.applyTo
import com.neoutils.highlight.view.extension.removeAllSpans

class HighlightTextWatcher(
    val highlight: Highlight
) : TextWatcher {

    override fun beforeTextChanged(
        s: CharSequence?,
        start: Int,
        count: Int,
        after: Int
    ) = Unit

    override fun onTextChanged(
        s: CharSequence?,
        start: Int,
        before: Int,
        count: Int
    ) = Unit

    override fun afterTextChanged(
        text: Editable
    ) {
        text.removeAllSpans()
        highlight.applyTo(text)
    }
}
