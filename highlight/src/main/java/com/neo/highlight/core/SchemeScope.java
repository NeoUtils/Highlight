package com.neo.highlight.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * @author Irineu A. Silva
 */
public interface SchemeScope {

    @Nullable
    List<Scheme> getScopeSchemes();
    public Scheme setScopeSchemes(List<Scheme> schemes);
    public Scheme addScopeScheme(@NonNull Scheme... scheme);
    public Scheme clearScopeSchemes();
}
