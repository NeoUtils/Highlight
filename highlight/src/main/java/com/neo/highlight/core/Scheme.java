package com.neo.highlight.core;

import java.util.regex.Pattern;

public interface Scheme {

    Pattern getRegex();

    /**
     * @return Um span novo deve ser gerado sempre que getSpan é chamado
     */
    Object getSpan();

}
