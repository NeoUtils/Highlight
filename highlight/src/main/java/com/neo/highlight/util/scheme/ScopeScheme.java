package com.neo.highlight.util.scheme;

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
final public class ScopeScheme implements Scheme, ScopeSchemeContract {

    @Nullable
    private List<Scheme> scopeSchemes;

    @NonNull
    private final Pattern pattern;

    private boolean clearOldSpan = false;

    public ScopeScheme(@NonNull Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    @NonNull
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    @Nullable
    public Object getSpan(@NonNull CharSequence text) {
        return null;
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    @Override
    public ScopeScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }

    @Nullable
    @Override
    public List<Scheme> getScopeSchemes() {
        return scopeSchemes;
    }

    @Override
    public ScopeScheme setScopeSchemes(List<Scheme> schemes) {
        scopeSchemes = schemes;
        return this;
    }

    @Override
    public ScopeScheme addScopeScheme(@NonNull Scheme... scheme) {

        if (scopeSchemes == null) {
            scopeSchemes = new ArrayList<>();
        }

        scopeSchemes.addAll(Arrays.asList(scheme));

        return null;
    }

    @Override
    public ScopeScheme clearScopeSchemes() {

        if (scopeSchemes != null) {
            scopeSchemes.clear();
        }

        return this;
    }
}
