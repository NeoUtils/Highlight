package com.neo.highlight.util.scheme;

import android.text.TextPaint;
import android.text.style.URLSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;

import java.util.regex.Pattern;

public class LinkScheme implements Scheme {

    @Nullable
    private final Pattern pattern = Pattern.compile("\\bhttps?://[^\\s]+\\b/?");

    private final boolean clearOldSpan;

    private boolean painText = true;

    public LinkScheme() {
        clearOldSpan = true;
    }

    public LinkScheme(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
    }

    public LinkScheme(boolean clearOldSpan, boolean painText) {
        this.clearOldSpan = clearOldSpan;
        this.painText = painText;
    }

    @Override
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    public Object getSpan(@NonNull CharSequence text) {
        return new URLSpan(text.toString()) {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {

                if (painText)
                    super.updateDrawState(ds);
            }
        };
    }

    public boolean getClearOldSpan() {
        return clearOldSpan;
    }
}
