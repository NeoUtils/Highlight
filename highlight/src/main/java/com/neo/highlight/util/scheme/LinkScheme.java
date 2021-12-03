package com.neo.highlight.util.scheme;

import android.text.TextPaint;
import android.text.style.URLSpan;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;

import java.util.regex.Pattern;

public class LinkScheme implements Scheme {

    @Nullable
    private final Pattern pattern = Pattern.compile("\\bhttps?://[^\\s]+\\b/?");

    private boolean clearOldSpan = true;

    private boolean painText = true;

    private boolean painTextUnderline = true;

    @ColorInt
    private int painTextColor = -1;

    @Override
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    public Object getSpan(@NonNull CharSequence text) {
        return new URLSpan(text.toString()) {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {

                if (painText) {

                    if (painTextColor == -1) {
                        ds.setColor(ds.linkColor);
                    } else {
                        ds.setColor(painTextColor);
                    }

                    ds.setUnderlineText(painTextUnderline);
                };
            }
        };
    }

    @Override
    public LinkScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }

    public LinkScheme setPainText(boolean painText) {
        this.painText = painText;
        return this;
    }

    public LinkScheme setPainTextColor(@ColorInt int painTextColor) {
        this.painTextColor = painTextColor;
        return setPainText(true);
    }

    public LinkScheme setPainTextUnderline(boolean painTextUnderline) {
        this.painTextUnderline = painTextUnderline;
        return this;
    }

    public boolean getClearOldSpan() {
        return clearOldSpan;
    }
}
