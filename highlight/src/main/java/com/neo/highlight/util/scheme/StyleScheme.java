package com.neo.highlight.util.scheme;

import android.graphics.Typeface;
import android.text.style.StyleSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;

import java.util.regex.Pattern;

/**
 * @author Irineu A. Silva
 */
public class StyleScheme implements Scheme {

    @Nullable
    private final Pattern pattern;

    @NonNull
    private final STYLE style;

    boolean clearOldSpan;

    public StyleScheme(@NonNull Pattern pattern, @NonNull STYLE style, boolean clearOldSpan) {
        this.pattern = pattern;
        this.style = style;
        this.clearOldSpan = clearOldSpan;
    }

    public StyleScheme(@NonNull Pattern pattern, @NonNull STYLE style) {
        this.pattern = pattern;
        this.style = style;
        this.clearOldSpan = false;
    }

    @Override
    public Pattern getRegex() {
        return pattern;
    }

    @NonNull
    @Override
    public Object getSpan(@NonNull CharSequence text) {
        return new StyleSpan(getType());
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    private int getType() {
        switch (style) {

            case NORMAL:
                return Typeface.NORMAL;
            case ITALIC:
                return Typeface.ITALIC;
            case BOLD:
                return Typeface.BOLD;
            case BOLD_ITALIC:
                return Typeface.BOLD_ITALIC;
        }

        return Typeface.NORMAL;
    }

    public enum STYLE {
        NORMAL,
        ITALIC,
        BOLD,
        BOLD_ITALIC
    }
}
