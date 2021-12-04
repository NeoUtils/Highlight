package com.neo.highlight.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.regex.Pattern;

/**
 * @author Irineu A. Silva
 */
public interface Scheme {

    @NonNull
    Pattern getRegex();

    @Nullable
    Object getSpan(@NonNull CharSequence text);

    boolean getClearOldSpan();

    @NonNull
    Scheme setClearOldSpan(boolean clearOldSpan);

}
