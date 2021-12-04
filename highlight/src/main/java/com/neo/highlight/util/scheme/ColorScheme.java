package com.neo.highlight.util.scheme;

import android.text.style.ForegroundColorSpan;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;
import com.neo.highlight.core.ScopeSchemeContract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Irineu A. Silva
 */
public class ColorScheme implements Scheme, ScopeSchemeContract {

    @Nullable
    private List<Scheme> scopeSchemes;

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
    @NonNull
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    @NonNull
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        return new ForegroundColorSpan(color);
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    @Override
    @NonNull
    public ColorScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }

    //override ScopeScheme

    @Nullable
    @Override
    public List<Scheme> getScopeSchemes() {
        return scopeSchemes;
    }

    @Override
    @NonNull
    public ColorScheme setScopeSchemes(@Nullable List<Scheme> schemes) {
        scopeSchemes = schemes;
        return this;
    }

    @Override
    public ColorScheme addScopeScheme(@NonNull Scheme... scheme) {

        if (scopeSchemes == null) {
            scopeSchemes = new ArrayList<>();
        }

        scopeSchemes.addAll(Arrays.asList(scheme));

        return this;
    }

    @Override
    public ColorScheme clearScopeSchemes() {
        if (scopeSchemes != null) {
            scopeSchemes.clear();
        }
        return this;
    }

}
