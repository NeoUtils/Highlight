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
import java.util.Arrays;
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

    //setSpan EdiText

    @Override
    public void setSpan(Editable editable) {
        setSpan(editable, 0, editable.length());
    }

    @Override
    public void setSpan(Editable editable, int start, int end) {
        setSpan(editable, schemes, start, end);
    }

    //EDITTEXT PROCESS
    private void setSpan(Editable editable, List<Scheme> schemes, int start, int end) {
        CharSequence subText = editable.subSequence(start, end);

        for (Scheme scheme : schemes) {

            Pattern regex = scheme.getRegex();

            Matcher matcher = regex.matcher(subText);

            while (matcher.find()) {

                CharSequence matcherText = subText.subSequence(
                        matcher.start(),
                        matcher.end()
                );

                int scopeStart = start + matcher.start();
                int scopeEnd = start + matcher.end();

                if (scheme.getClearOldSpan()) {
                    removeSpan(
                            editable,
                            scopeStart,
                            scopeEnd
                    );
                }

                Object span = scheme.getSpan(matcherText);

                if (span != null) {
                    SpanUtils.setSpan(
                            editable,
                            span,
                            scopeStart,
                            scopeEnd
                    );
                }

                //scope scheme
                if (scheme instanceof ScopeSchemeContract) {

                    ScopeSchemeContract schemeScope = (ScopeSchemeContract) scheme;
                    List<Scheme> schemeScopes = schemeScope.getScopeSchemes();

                    if (schemeScopes != null) {
                        setSpan(editable, schemeScopes,
                                scopeStart,
                                scopeEnd
                        );
                    }
                }
            }
        }
    }

    //setSpan TextView

    @Override
    public void setSpan(TextView textView) {
        setSpan(textView, 0, textView.length());
    }

    @Override
    public void setSpan(TextView textView, int start, int end) {
        if (textView instanceof EditText) {
            setSpan((Editable) textView.getText(), start, end);
        } else {

            SpannableString spannableString =
                    new SpannableString(textView.getText());

            setSpan(spannableString, start, end);

            textView.setText(spannableString);
        }
    }

    //setSpan Spannable

    @Override
    public void setSpan(SpannableString spannableString) {
        setSpan(spannableString,0, spannableString.length());
    }

    @Override
    public void setSpan(SpannableString spannableString, int start, int end) {
        setSpan(spannableString, schemes, start, end);
    }

    //SPANNABLE PROCESS
    private void setSpan(SpannableString spannableString, List<Scheme> schemes, int start, int end) {
        CharSequence subText = spannableString.subSequence(start, end);

        for (Scheme scheme : schemes) {

            Pattern regex = scheme.getRegex();

            Matcher matcher = regex.matcher(subText);

            while (matcher.find()) {

                CharSequence matcherText = subText.subSequence(
                        matcher.start(),
                        matcher.end()
                );

                int scopeStart = start + matcher.start();
                int scopeEnd = start + matcher.end();

                if (scheme.getClearOldSpan()) {
                    removeSpan(
                            spannableString,
                            scopeStart,
                            scopeEnd
                    );
                }

                Object span = scheme.getSpan(matcherText);
                if (span != null) {
                    spannableString.setSpan(
                            span,
                            scopeStart,
                            scopeEnd,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                }

                //scope scheme
                if (scheme instanceof ScopeSchemeContract) {

                    ScopeSchemeContract schemeScope = (ScopeSchemeContract) scheme;
                    List<Scheme> schemeScopes = schemeScope.getScopeSchemes();

                    if (schemeScopes != null && !schemeScopes.isEmpty()) {
                        setSpan(spannableString, schemeScopes, scopeStart, scopeEnd);
                    }
                }
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
    public void addScheme(@NonNull Scheme... scheme) {
        this.schemes.addAll(Arrays.asList(scheme));
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

        setSpan(spannableString);

        return spannableString;
    }

    private void removeSpan(SpannableString spannableString, int start, int end) {

        for (Class<?> spanClass : spanTypes) {
            for (Object span : spannableString.getSpans(start, end, spanClass)) {
                spannableString.removeSpan(span);
            }
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
