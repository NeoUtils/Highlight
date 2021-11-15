package com.neo.highlightproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;

import com.neo.highlight.core.Highlight;
import com.neo.highlight.core.Scheme;
import com.neo.highlight.util.listener.HighlightTextWatcher;
import com.neo.highlight.util.scheme.ColorScheme;
import com.neo.highlight.util.scheme.StyleScheme;
import com.neo.highlightproject.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initHighlightExample();
    }

    private void initHighlightExample() {
        HighlightTextWatcher highlightTextWatcher =
                new HighlightTextWatcher();

        highlightTextWatcher.addScheme(
                new ColorScheme(
                        "\\b(J|j)ava\\b",
                        Color.parseColor("#FC0400")
                )
        );

        highlightTextWatcher.addScheme(
                new ColorScheme(
                        "\\b(K|k)otlin\\b",
                        Color.parseColor("#FC8500")
                )
        );

        highlightTextWatcher.addScheme(
                new ColorScheme(
                        "\\b(J|j)ava(S|s)cript\\b",
                        Color.parseColor("#F5E200")
                )
        );

        highlightTextWatcher.addScheme(
                new ColorScheme(
                        "\\b(A|a)ndroid\\b",
                        Color.parseColor("#00CA0E")
                )
        );

        highlightTextWatcher.addScheme(
                new StyleScheme(
                        "\\b([Hh])ighlight\\b",
                        StyleScheme.STYLE.BOLD_ITALIC
                )
        );

        //custom example
        highlightTextWatcher.addScheme(
                new Scheme() {
                    final Pattern pattern =
                            Pattern.compile("\\b([Jj])ava([Ss])cript\\b");

                    @Override
                    public Pattern getRegex() {
                        return pattern;
                    }

                    @Override
                    public Object getSpan() {
                        return new StrikethroughSpan();
                    }
                }
        );

        //custom example 2
        highlightTextWatcher.addScheme(
                new Scheme() {
                    final Pattern pattern =
                            Pattern.compile("\\b([Hh])ighlight\\b");

                    @Override
                    public Pattern getRegex() {
                        return pattern;
                    }

                    @Override
                    public Object getSpan() {
                        return new UnderlineSpan();
                    }
                }
        );

        highlightTextWatcher.addSpanType(StrikethroughSpan.class);

        binding.edittext.addTextChangedListener(highlightTextWatcher);

        binding.edittext.setText(R.string.example);
    }
}