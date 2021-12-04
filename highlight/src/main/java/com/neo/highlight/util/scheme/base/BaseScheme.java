package com.neo.highlight.util.scheme.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;
import com.neo.highlight.util.scheme.contract.ScopeScheme;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

abstract public class BaseScheme implements Scheme, ScopeScheme {

    @Nullable
    private List<Scheme> scopeSchemes;

    @Nullable
    private final Pattern pattern;

    private boolean clearOldSpan = false;

    public BaseScheme(@Nullable Pattern pattern) {
        this.pattern = pattern;
    }

    //override Scheme

    @Nullable
    @Override
    public Pattern getRegex() {
        return pattern;
    }


    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    @NonNull
    @Override
    public BaseScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }

    //override ScopeSchemeContract

    @Nullable
    @Override
    public List<Scheme> getScopeSchemes() {
        return scopeSchemes;
    }

    @Override
    public void setScopeSchemes(@Nullable List<Scheme> schemes) {
        this.scopeSchemes = schemes;
    }

    @Override
    public BaseScheme addScopeScheme(@NonNull Scheme... scheme) {
        if (scopeSchemes != null) {
            scopeSchemes.addAll(Arrays.asList(scheme));
        }
        return null;
    }

    @Override
    public BaseScheme clearScopeSchemes() {
        if (scopeSchemes != null) {
            scopeSchemes.clear();
        }
        return this;
    }
}
