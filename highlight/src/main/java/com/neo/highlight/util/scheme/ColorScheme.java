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

    @Nullable
    Pattern pattern;

    @ColorInt
    private final int color;

    public ColorScheme(@NonNull String regex, @ColorInt int color) {
        this(Pattern.compile(regex), color);
    }

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
}
