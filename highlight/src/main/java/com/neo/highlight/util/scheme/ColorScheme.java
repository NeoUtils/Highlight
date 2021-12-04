package com.neo.highlight.util.scheme;

import android.text.style.ForegroundColorSpan;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Paint the text
 * @author Irineu A. Silva
 */
final public class ColorScheme extends BaseColorScheme {

    public ColorScheme(@NonNull Pattern pattern, @ColorInt int color) {
        super(pattern, color);
    }

    public ColorScheme(@ColorInt int color) {
        super(color);
    }

    @Override
    @NonNull
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        return new ForegroundColorSpan(color);
    }
}
