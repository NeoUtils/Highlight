package com.neo.highlight.core;

import android.text.Editable;

import androidx.annotation.NonNull;

import java.util.List;

public interface HighlightContract {
    public void setSpan(Editable editable, int start, int end);
    public void setSpan(Editable editable);
    public void removeSpan(Editable editable);
    public void removeSpan(Editable editable, int start, int end);
    public List<Scheme> getSchemes();
    public void setSchemes(@NonNull List<Scheme> schemes);
    public void addScheme(@NonNull Scheme scheme);
    public void clearScheme();
    public List<Class<?>> getSpanTypes();
    public void setSpanTypes(@NonNull List<Class<?>> spanTypes);
    public void addSpanType(Class<?> span);
    public void clearSpanTypes();
}
