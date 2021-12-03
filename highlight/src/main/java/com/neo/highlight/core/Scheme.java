package com.neo.highlight.core;

import androidx.annotation.NonNull;

import java.util.regex.Pattern;

public interface Scheme {

    Pattern getRegex();

    /**
     * @return Um span novo deve ser gerado sempre que getSpan é chamado
     * @param text trecho destacado
     */
    Object getSpan(@NonNull CharSequence text);

    boolean getClearOldSpan();

    Scheme setClearOldSpan(boolean clearOldSpan);

}
