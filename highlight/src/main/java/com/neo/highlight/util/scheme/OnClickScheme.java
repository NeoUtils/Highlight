package com.neo.highlight.util.scheme;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

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
public class OnClickScheme implements Scheme, ScopeSchemeContract {

    @Nullable
    private List<Scheme> scopeSchemes;

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

    @NonNull
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

    @NonNull
    @Override
    public OnClickScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }

    public OnClickScheme setPainText(boolean painText) {
        this.painText = painText;
        return this;
    }

    public OnClickScheme setPainTextColor(@ColorInt int painTextColor) {
        this.painTextColor = painTextColor;
        return setPainText(true);
    }

    public OnClickScheme setPainTextUnderline(boolean painTextUnderline) {
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
    public OnClickScheme setScopeSchemes(@Nullable List<Scheme> schemes) {
        scopeSchemes = schemes;
        return this;
    }

    @Override
    public OnClickScheme addScopeScheme(@NonNull Scheme... scheme) {

        if (scopeSchemes == null) {
            scopeSchemes = new ArrayList<>();
        }

        scopeSchemes.addAll(Arrays.asList(scheme));

        return this;
    }

    @Override
    public OnClickScheme clearScopeSchemes() {
        if (scopeSchemes != null) {
            scopeSchemes.clear();
        }
        return this;
    }

    public interface OnClickListener {
        void onClick(CharSequence text);
    }
}
