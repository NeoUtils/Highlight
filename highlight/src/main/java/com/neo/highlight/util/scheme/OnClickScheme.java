package com.neo.highlight.util.scheme;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.NonNull;

import com.neo.highlight.core.Scheme;

import java.util.regex.Pattern;

public class OnClickScheme implements Scheme {

    @NonNull
    private final OnClickListener onClickListener;

    @NonNull
    private final Pattern pattern;

    private boolean painText = false;

    private boolean clearOldSpan = false;

    public OnClickScheme(@NonNull Pattern pattern, @NonNull OnClickListener onClickListener) {
        this.pattern = pattern;
        this.onClickListener = onClickListener;
    }

    public OnClickScheme(@NonNull Pattern pattern, @NonNull OnClickListener onClickListener, boolean clearOldSpan) {
        this.pattern = pattern;
        this.onClickListener = onClickListener;
        this.clearOldSpan = clearOldSpan;
    }

    public OnClickScheme(@NonNull Pattern pattern, @NonNull OnClickListener onClickListener, boolean clearOldSpan, boolean painText) {
        this.pattern = pattern;
        this.onClickListener = onClickListener;
        this.clearOldSpan = clearOldSpan;
        this.painText = painText;
    }

    @Override
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    public Object getSpan(@NonNull final CharSequence text) {
        return new ClickableSpan() {

            @Override
            public void onClick(@NonNull View widget) {
                onClickListener.onClick(text);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {

                if (painText)
                    super.updateDrawState(ds);
            }
        };
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    public interface OnClickListener {
        void onClick(CharSequence text);
    }
}
