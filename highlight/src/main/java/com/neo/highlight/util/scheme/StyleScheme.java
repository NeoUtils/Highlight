package com.neo.highlight.util.scheme;

import android.graphics.Typeface;
import android.text.style.StyleSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;
import com.neo.highlight.core.SchemeScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Irineu A. Silva
 */
public class StyleScheme implements Scheme, SchemeScope {

    @Nullable
    private List<Scheme> scopedSchemes;

    @NonNull
    private final Pattern pattern;

    @NonNull
    private final STYLE style;

    private boolean clearOldSpan = false;

    public StyleScheme(@NonNull Pattern pattern, @NonNull STYLE style) {
        this.pattern = pattern;
        this.style = style;
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

    @Override
    public StyleScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
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

    //override ScopeScheme

    @Override
    @Nullable
    public List<Scheme> getScopeSchemes() {
        return scopedSchemes;
    }

    @Override
    public StyleScheme setScopeSchemes(@Nullable List<Scheme> schemes) {
        scopedSchemes = schemes;
        return this;
    }

    @Override
    public StyleScheme addScopeScheme(@NonNull Scheme... scheme) {

        if (scopedSchemes == null) {
            scopedSchemes = new ArrayList<>();
        }

        scopedSchemes.addAll(Arrays.asList(scheme));

        return this;
    }

    @Override
    public StyleScheme clearScopeSchemes() {
        if (scopedSchemes != null) {
            scopedSchemes.clear();
        }
        return this;
    }

    public enum STYLE {
        NORMAL,
        ITALIC,
        BOLD,
        BOLD_ITALIC
    }
}
