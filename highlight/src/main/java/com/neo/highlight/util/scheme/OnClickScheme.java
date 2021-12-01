package com.neo.highlight.util.scheme;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.neo.highlight.core.Scheme;

import java.util.regex.Pattern;

public class OnClickScheme implements Scheme {

    @NonNull
    private final OnClickListener onClickListener;

    @NonNull
    private final Pattern pattern;

    private boolean painText = false;

    @ColorInt
    private int painTextColor = -1;

    private boolean clearOldSpan = false;

    private boolean painTextUnderline = false;

    public OnClickScheme(@NonNull Pattern pattern, @NonNull OnClickListener onClickListener) {
        this.pattern = pattern;
        this.onClickListener = onClickListener;
    }

    public OnClickScheme setPainText(boolean painText) {
        this.painText = painText;
        return this;
    }

    public OnClickScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
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

                if (painText) {

                    if (painTextColor == -1) {
                        ds.setColor(ds.linkColor);
                    } else {
                        ds.setColor(painTextColor);
                    }

                    ds.setUnderlineText(painTextUnderline);
                }
            }
        };
    }

    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    public OnClickScheme setPainTextColor(@ColorInt int painTextColor) {
        this.painTextColor = painTextColor;
        return setPainText(true);
    }

    public OnClickScheme setPainTextUnderline(boolean painTextUnderline) {
        this.painTextUnderline = painTextUnderline;
        return this;
    }

    public interface OnClickListener {
        void onClick(CharSequence text);
    }
}
