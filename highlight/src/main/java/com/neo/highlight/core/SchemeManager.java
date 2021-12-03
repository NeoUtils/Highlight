package com.neo.highlight.core;

import androidx.annotation.NonNull;

import java.util.List;

public interface SchemeManager {
    void setSchemes(@NonNull List<Scheme> schemes);
    void addScheme(@NonNull Scheme scheme);
    void clearScheme();
}
