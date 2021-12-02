package com.neo.highlight.core;

import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Irineu A. Silva
 */
public class Highlight implements HighlightContract {

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

    @Override
    public void setSpan(Editable editable, int start, int end) {

        CharSequence subText = editable.subSequence(start, end);

        for (Scheme scheme : schemes) {

            Pattern regex = scheme.getRegex();

            Matcher matcher = regex.matcher(subText);

            while (matcher.find()) {

                CharSequence matcherText = subText.subSequence(
                        matcher.start(),
                        matcher.end()
                );

                if (scheme.getClearOldSpan()) {
                    removeSpan(
                            editable,
                            start + matcher.start(),
                            start + matcher.end()
                    );
                }

                SpanUtils.setSpan(
                        editable,
                        scheme.getSpan(matcherText),
                        start + matcher.start(),
                        start + matcher.end()
                );
            }
        }
    }

    @Override
    public void setSpan(Editable editable) {
        for (Scheme scheme : schemes) {

            Pattern regex = scheme.getRegex();

            Matcher matcher = regex.matcher(editable);

            while (matcher.find()) {

                CharSequence matcherText = editable.subSequence(
                        matcher.start(),
                        matcher.end()
                );

                if (scheme.getClearOldSpan()) {
                    removeSpan(
                            editable,
                            matcher.start(),
                            matcher.end()
                    );
                }

                SpanUtils.setSpan(
                        editable,
                        scheme.getSpan(matcherText),
                        matcher.start(),
                        matcher.end()
                );
            }
        }
    }

    @Override
    public void removeSpan(Editable editable) {

        for (Class<?> span : spanTypes) {
            SpanUtils.removeSpans(editable, span, 0, editable.length());
        }
    }

    @Override
    public void removeSpan(Editable editable, int start, int end) {

        for (Class<?> span : spanTypes) {
            SpanUtils.removeSpans(editable, span, start, end);
        }
    }

    @Override
    @NonNull
    public List<Scheme> getSchemes() {
        return new ArrayList<>(schemes);
    }

    @Override
    public void setSchemes(@NonNull List<Scheme> schemes) {
        this.schemes = new ArrayList<>(schemes);
    }

    @Override
    public void addScheme(@NonNull Scheme scheme) {
        this.schemes.add(scheme);
    }

    @Override
    public void clearScheme() {
        this.schemes.clear();
    }

    @Override
    @NonNull
    public List<Class<?>> getSpanTypes() {
        return new ArrayList<>(spanTypes);
    }

    @Override
    public void setSpanTypes(@NonNull List<Class<?>> spanTypes) {
        this.spanTypes = new ArrayList<>(spanTypes);
        configDefaultSpanTypes();
    }

    @Override
    public void addSpanType(Class<?> span) {
        if (!spanTypes.contains(span))
            this.spanTypes.add(span);
    }

    @Override
    public void clearSpanTypes() {
        this.spanTypes.clear();
        configDefaultSpanTypes();
    }

    public SpannableString getSpannable(CharSequence text) {

        SpannableString spannableString =
                new SpannableString(text);

        for (Scheme scheme : schemes) {

            Pattern regex = scheme.getRegex();

            Matcher matcher = regex.matcher(spannableString);

            while (matcher.find()) {

                CharSequence matcherText = text.subSequence(
                        matcher.start(),
                        matcher.end()
                );

                if (scheme.getClearOldSpan()) {
                    removeSpan(
                            spannableString,
                            matcher.start(),
                            matcher.end()
                    );
                }

                spannableString.setSpan(
                        scheme.getSpan(matcherText),
                        matcher.start(),
                        matcher.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                );
            }
        }

        return spannableString;
    }

    private void removeSpan(SpannableString spannableString, int start, int end) {

        for (Class<?> spanClass : spanTypes) {
            for (Object span : spannableString.getSpans(start, end, spanClass)) {
                spannableString.removeSpan(span);
            }
        }
    }

    public void setSpan(TextView textView) {

        if (textView instanceof EditText) {
            setSpan((Editable) textView.getText());
        } else {
            textView.setText(getSpannable(textView.getText()));
        }
    }

    private void configDefaultSpanTypes() {
        addSpanType(ForegroundColorSpan.class);
        addSpanType(BackgroundColorSpan.class);
        addSpanType(StyleSpan.class);
        addSpanType(URLSpan.class);
        addSpanType(ClickableSpan.class);
    }
}
