package com.neo.highlight.util.scheme;

import android.text.TextPaint;
import android.text.style.URLSpan;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;
import com.neo.highlight.core.ScopeSchemeContract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Irineu A. Silva
 */
public class LinkScheme implements Scheme, ScopeSchemeContract {

    @Nullable
    private List<Scheme> scopeSchemes;

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

    //override ScopeScheme

    @Nullable
    @Override
    public List<Scheme> getScopeSchemes() {
        return scopeSchemes;
    }

    @Override
    public LinkScheme setScopeSchemes(@Nullable List<Scheme> schemes) {
        scopeSchemes = schemes;
        return this;
    }

    @Override
    public LinkScheme addScopeScheme(@NonNull Scheme... scheme) {

        if (scopeSchemes == null) {
            scopeSchemes = new ArrayList<>();
        }

        scopeSchemes.addAll(Arrays.asList(scheme));

        return this;
    }

    @Override
    public LinkScheme clearScopeSchemes() {
        if (scopeSchemes != null) {
            scopeSchemes.clear();
        }
        return this;
    }


    public boolean getClearOldSpan() {
        return clearOldSpan;
    }
}
