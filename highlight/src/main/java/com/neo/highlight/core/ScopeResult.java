package com.neo.highlight.core;

import androidx.annotation.NonNull;

public class ScopeResult {

    @NonNull
    private final CharSequence text;
    private final int start, end;


    public ScopeResult(@NonNull CharSequence text, int start, int end) {
        this.text = text;
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @NonNull
    public CharSequence getText() {
        return text;
    }
}
