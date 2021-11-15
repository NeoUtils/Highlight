package com.neo.highlight.core;

import android.text.Editable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Irineu A. Silva
 */
public class Highlight {

    @NonNull
    private List<Scheme> schemes;

    @NonNull
    private List<Class<?>> spanTypes;

    public Highlight() {
        this(new ArrayList<Scheme>());
    }

    public Highlight(@NonNull List<Scheme> schemes) {
        this.schemes = schemes;

        spanTypes = new ArrayList<>();
        configDefaultSpanTypes();
    }

    public void setSpan(Editable editable, int start, int end) {

        CharSequence subText = editable.subSequence(start, end);

        for (Scheme scheme : schemes) {

            Pattern regex = scheme.getRegex();

            Matcher matcher = regex.matcher(subText);

            while (matcher.find()) {
                SpanUtils.setSpan(
                        editable, scheme.getSpan(),
                        start + matcher.start(),
                        start + matcher.end()
                );
            }
        }
    }

    public void setSpan(Editable editable) {
        for (Scheme scheme : schemes) {

            Pattern regex = scheme.getRegex();

            Matcher matcher = regex.matcher(editable);

            while (matcher.find()) {
                SpanUtils.setSpan(
                        editable,
                        scheme.getSpan(),
                        matcher.start(),
                        matcher.end()
                );
            }
        }
    }

    public void removeSpan(Editable editable) {

        for (Class<?> span : spanTypes) {
            SpanUtils.removeSpans(editable, span, 0, editable.length());
        }
    }

    public void removeSpan(Editable editable, int start, int end) {

        for (Class<?> span : spanTypes) {
            SpanUtils.removeSpans(editable, span, start, end);
        }
    }

    @NonNull
    public List<Scheme> getSchemes() {
        return new ArrayList<>(schemes);
    }

    public void setSchemes(@NonNull List<Scheme> schemes) {
        this.schemes = new ArrayList<>(schemes);
    }

    public void addScheme(@NonNull Scheme scheme) {
        this.schemes.add(scheme);
    }

    public void clearScheme() {
        this.schemes.clear();
    }

    @NonNull
    public List<Class<?>> getSpanTypes() {
        return new ArrayList<>(spanTypes);
    }

    public void setSpanTypes(@NonNull List<Class<?>> spanTypes) {
        this.spanTypes = new ArrayList<>(spanTypes);
        configDefaultSpanTypes();
    }

    public void addSpanType(Class<?> span) {
        this.spanTypes.add(span);
    }

    public void clearSpanTypes() {
        this.spanTypes.clear();
        configDefaultSpanTypes();
    }

    private void configDefaultSpanTypes() {
        spanTypes.add(ForegroundColorSpan.class);
        spanTypes.add(BackgroundColorSpan.class);
        spanTypes.add(StyleSpan.class);
    }
}
