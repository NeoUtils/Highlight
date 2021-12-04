package com.neo.highlight.util.scheme.base;

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
 * Base to spannable colors
 * @author Irineu A. Silva
 */
abstract public class BaseColorScheme extends BaseScheme {

    @ColorInt
    protected final int color;

    public BaseColorScheme(@NonNull Pattern pattern, @ColorInt int color) {
        super(pattern);
        this.color = color;
    }

    public BaseColorScheme(@ColorInt int color) {
        super(null);
        this.color = color;
    }
}
