package com.neo.highlightproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.neo.highlight.core.Highlight;
import com.neo.highlight.core.Scheme;
import com.neo.highlight.core.SpanUtils;
import com.neo.highlight.util.listener.HighlightTextWatcher;
import com.neo.highlight.util.scheme.ColorScheme;
import com.neo.highlight.util.scheme.FontScheme;
import com.neo.highlight.util.scheme.Scope;
import com.neo.highlight.util.scheme.StyleScheme;
import com.neo.highlightproject.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configToolbar();

        initTest(binding.edittext);

    }

    private void configToolbar() {

        Highlight highlight = new Highlight();

        //add scheme
        highlight.addScheme(
                new StyleScheme(
                        Pattern.compile("Highlight"),
                        StyleScheme.STYLE.BOLD_ITALIC
                ).addScopeScheme(
                        //add scheme scheme
                        new ColorScheme(
                                Pattern.compile("light"),
                                Color.parseColor("#FF03DAC5")
                        )
                )
        );

        highlight.addScheme(
                new ColorScheme(
                        Pattern.compile("Project"),
                        Color.BLACK
                ).addScopeScheme(
                        new FontScheme(
                                FontScheme.getFont(this, R.font.pacifico_regular)
                        )
                )
        );

        highlight.setSpan(binding.toolbarTitle);
    }

    private void goToUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @SuppressLint("SetTextI18n")
    private void initTest(EditText edittext) {
        HighlightTextWatcher highlight = new HighlightTextWatcher();

        highlight.setSchemes(getKotlinScheme());

        edittext.addTextChangedListener(highlight);

        edittext.setText(
                "fun main() {\n" +
                        "    println(\"Olá, mundo!\")\n" +
                        "}"
        );
    }

    private List<Scheme> getKotlinScheme() {

        List<Scheme> schemes = new ArrayList<>();

        //keywords
        schemes.add(
                new ColorScheme(
                        Pattern.compile("\\b(fun)\\b"),
                        ContextCompat.getColor(this, R.color.keyword)
                )
        );

        //function
        schemes.add(
                new Scope(
                        Pattern.compile("\\b(fun)\\b\\s*\\b\\w+\\b\\([^()]*\\)")
                ).addScopeScheme(
                        new ColorScheme(
                                Pattern.compile("\\w*(?=\\()"),
                                ContextCompat.getColor(this, R.color.function)
                        )
                )
        );

        //strings
        schemes.add(
                new ColorScheme(
                        Pattern.compile("\"[^\"]*\""),
                        ContextCompat.getColor(this, R.color.string)
                )
        );

        return schemes;
    }

}