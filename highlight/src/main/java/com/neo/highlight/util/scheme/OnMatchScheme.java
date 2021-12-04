package com.neo.highlight.util.scheme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;

import java.util.regex.Pattern;

public class OnMatchScheme implements Scheme {

    @NonNull
    private final OnMatchListener onMatchListener;

    @Nullable
    private final Pattern pattern;

    private boolean clearOldSpan = false;

    public OnMatchScheme(@NonNull Pattern pattern, @NonNull OnMatchListener onMatchListener) {
        this.pattern = pattern;
        this.onMatchListener = onMatchListener;
    }

    public OnMatchScheme( @NonNull OnMatchListener onMatchListener) {
        this.pattern = null;
        this.onMatchListener = onMatchListener;
    }

    @Nullable
    @Override
    public Pattern getRegex() {
        return pattern;
    }

    @Nullable
    @Override
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        onMatchListener.onMatch(text, start, end);
        return null;
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    @NonNull
    @Override
    public Scheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }

    public interface OnMatchListener{
        void onMatch(CharSequence text, int start, int end);
    }
}
