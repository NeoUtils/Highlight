package com.neo.highlight.util.scheme;

import android.text.style.ForegroundColorSpan;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;

import java.util.regex.Pattern;

/**
 * @author Irineu A. Silva
 */
public class ColorScheme implements Scheme {

    @NonNull
    private final Pattern pattern;

    @ColorInt
    private final int color;

    private boolean clearOldSpan = false;

    public ColorScheme(@NonNull Pattern pattern, @ColorInt int color) {
        this.pattern = pattern;
        this.color = color;
    }

    @Override
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    public Object getSpan(@NonNull CharSequence text) {
        return new ForegroundColorSpan(color);
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    @Override
    public ColorScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }
}
