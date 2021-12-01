package com.neo.highlight.util.scheme;

import android.text.style.URLSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;

import java.util.regex.Pattern;

public class LinkScheme implements Scheme {

    @Nullable
    Pattern pattern = Pattern.compile("\\bhttps?://[^\\s]+\\b/?");

    boolean clearOldSpan;

    public LinkScheme() {
        clearOldSpan = true;
    }

    public LinkScheme(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
    }

    @Override
    public Pattern getRegex() {
        return pattern;
    }

    @Override
    public Object getSpan(@NonNull CharSequence text) {
        return new URLSpan(text.toString());
    }

    public boolean getClearOldSpan() {
        return clearOldSpan;
    }
}
