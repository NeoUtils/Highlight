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

    @NonNull
    private List<Scheme> scopeSchemes;

    @NonNull
    private final Pattern pattern;

    private boolean clearOldSpan = false;

    public ScopeScheme(@NonNull Pattern pattern, @NonNull Scheme... scopeSchemes) {
        this.pattern = pattern;
        this.scopeSchemes = Arrays.asList(scopeSchemes);
    }

    @Override
    @NonNull
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    @Nullable
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        return null;
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    @NonNull
    @Override
    public ScopeScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }

    @NonNull
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
        scopeSchemes.addAll(Arrays.asList(scheme));
        return this;
    }

    @Override
    public ScopeScheme clearScopeSchemes() {
        scopeSchemes.clear();
        return this;
    }
}
