package com.neo.highlight.util.scheme;

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
 * Base to spannable colors
 * @author Irineu A. Silva
 */
abstract public class BaseColorScheme implements Scheme, ScopeSchemeContract {

    @Nullable
    private List<Scheme> scopeSchemes;

    @Nullable
    private final Pattern pattern;

    @ColorInt
    protected final int color;

    private boolean clearOldSpan = false;

    public BaseColorScheme(@NonNull Pattern pattern, @ColorInt int color) {
        this.pattern = pattern;
        this.color = color;
    }

    public BaseColorScheme(@ColorInt int color) {
        this.pattern = null;
        this.color = color;
    }

    @Override
    @Nullable
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    @Override
    @NonNull
    public Scheme setClearOldSpan(boolean clearOldSpan) {
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
    public Scheme setScopeSchemes(@Nullable List<Scheme> schemes) {
        scopeSchemes = schemes;
        return this;
    }

    @Override
    public Scheme addScopeScheme(@NonNull Scheme... scheme) {

        if (scopeSchemes == null) {
            scopeSchemes = new ArrayList<>();
        }

        scopeSchemes.addAll(Arrays.asList(scheme));

        return this;
    }

    @Override
    public Scheme clearScopeSchemes() {
        if (scopeSchemes != null) {
            scopeSchemes.clear();
        }
        return this;
    }
}
