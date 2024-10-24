package com.neoutils.highlight.view.span

import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.TypefaceSpan

data class FontSpan(
    private val typeface: Typeface
) : TypefaceSpan(null) {

    override fun updateDrawState(paint: TextPaint) {
        paint.setTypeface(typeface)
    }

    override fun updateMeasureState(paint: TextPaint) {
        paint.setTypeface(typeface)
    }
}