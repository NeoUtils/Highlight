package com.neo.highlight.util.scheme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.ScopeResult;
import com.neo.highlight.util.scheme.base.BaseScheme;

import java.util.regex.Pattern;

/**
 * Execute action when match
 * @author Irineu A. Silva
 */
final public class OnMatchScheme extends BaseScheme {

    @NonNull
    private final OnMatchListener onMatchListener;

    public OnMatchScheme(@NonNull Pattern pattern, @NonNull OnMatchListener onMatchListener) {
        super(pattern);
        this.onMatchListener = onMatchListener;
    }

    public OnMatchScheme(@NonNull OnMatchListener onMatchListener) {
        super(null);
        this.onMatchListener = onMatchListener;
    }

    @Nullable
    @Override
    public Object getSpan(@NonNull ScopeResult scopeResult) {
        onMatchListener.onMatch(scopeResult);
        return null;
    }

    public interface OnMatchListener {
        void onMatch(@NonNull ScopeResult scopeResult);
    }
}
