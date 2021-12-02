package com.neo.highlight.core;

import android.text.Editable;

import androidx.annotation.NonNull;

import java.util.List;

public interface HighlightContract {
    void setSpan(Editable editable, int start, int end);
    void setSpan(Editable editable);
    void removeSpan(Editable editable);
    void removeSpan(Editable editable, int start, int end);
    List<Scheme> getSchemes();
    void setSchemes(@NonNull List<Scheme> schemes);
    void addScheme(@NonNull Scheme scheme);
    void clearScheme();
    List<Class<?>> getSpanTypes();
    void setSpanTypes(@NonNull List<Class<?>> spanTypes);
    void addSpanType(Class<?> span);
    void clearSpanTypes();
}
