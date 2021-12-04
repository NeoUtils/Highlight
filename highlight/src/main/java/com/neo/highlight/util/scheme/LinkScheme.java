package com.neo.highlight.util.scheme;

import android.text.TextPaint;
import android.text.style.URLSpan;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;
import com.neo.highlight.core.ScopeSchemeContract;
import com.neo.highlight.util.scheme.base.BaseScheme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Pain and makes clickable links
 * @author Irineu A. Silva
 */
final public class LinkScheme extends BaseScheme {

    private boolean painText = true;

    private boolean painTextUnderline = true;

    @ColorInt
    private int painTextColor = -1;

    public LinkScheme() {
        super(Pattern.compile("\\bhttps?://[^\\s]+\\b/?"));
    }

    @Override
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
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
}
