package com.neo.highlightproject;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.LinkMovementMethod;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.neo.highlight.core.Highlight;
import com.neo.highlight.core.Scheme;
import com.neo.highlight.util.listener.HighlightTextWatcher;
import com.neo.highlight.util.scheme.ColorScheme;
import com.neo.highlight.util.scheme.LinkScheme;
import com.neo.highlight.util.scheme.OnClickScheme;
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
        configToolbar();
        initHighlightExample();
    }

    private void configToolbar() {

        Highlight highlight = new Highlight();

        highlight.addScheme(
                new StyleScheme(
                        Pattern.compile("Highlight"),
                        StyleScheme.STYLE.BOLD_ITALIC
                ).addScopeScheme(
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
                )
        );


        highlight.setSpan(binding.toolbarTitle);
    }


    private void initHighlightExample() {
        HighlightTextWatcher highlightTextWatcher =
                new HighlightTextWatcher();

        highlightTextWatcher.addScheme(
                new ColorScheme(
                        Pattern.compile("\\b([Jj])ava\\b"),
                        Color.parseColor("#FC0400")
                )
        );

        highlightTextWatcher.addScheme(
                new ColorScheme(
                        Pattern.compile("\\b([Kk])otlin\\b"),
                        Color.parseColor("#FC8500")
                )
        );

        highlightTextWatcher.addScheme(
                new ColorScheme(
                        Pattern.compile("\\b([Jj])ava([Ss])cript\\b"),
                        Color.parseColor("#F5E200")
                )
        );

        highlightTextWatcher.addScheme(
                new ColorScheme(
                        Pattern.compile("\\b([Aa])ndroid\\b"),
                        Color.parseColor("#00CA0E")
                )
        );

        highlightTextWatcher.addScheme(
                new StyleScheme(
                        Pattern.compile("\\b([Hh])ighlight\\b"),
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
                    public Object getSpan(@NonNull CharSequence text) {
                        return new StrikethroughSpan();
                    }

                    @Override
                    public boolean getClearOldSpan() {
                        return false;
                    }

                    @Override
                    public Scheme setClearOldSpan(boolean clearOldSpan) {
                        return this;
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
                    public Object getSpan(@NonNull CharSequence text) {
                        return new UnderlineSpan();
                    }

                    @Override
                    public boolean getClearOldSpan() {
                        return false;
                    }

                    @Override
                    public Scheme setClearOldSpan(boolean clearOldSpan) {
                        return this;
                    }
                }
        );

        highlightTextWatcher.addSpanType(StrikethroughSpan.class);

        //add link scheme

        highlightTextWatcher.addScheme(
                new LinkScheme().setClearOldSpan(true)
        );

        binding.edittext.setMovementMethod(LinkMovementMethod.getInstance());

        //add click scheme

        highlightTextWatcher.addScheme(
                new OnClickScheme(Pattern.compile("[hH]ighlight"), (CharSequence text) -> showToast())
        );

        highlightTextWatcher.addScheme(
                new OnClickScheme(Pattern.compile("Irineu A\\. Silva"), (CharSequence text) ->
                        goToMyGithub()
                ).setPainTextColor(Color.GRAY)
        );

        binding.edittext.addTextChangedListener(highlightTextWatcher);

        //binding.edittext.setText(R.string.example);
        initAutoText(getString(R.string.example));
    }

    private void goToMyGithub() {
        String url = "https://github.com/Irineu333";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private void showToast() {
        Toast.makeText(
                MainActivity.this,
                "Highlight is the best!!",
                Toast.LENGTH_SHORT
        ).show();
    }

    private void initAutoText(String text) {

        binding.edittext.setText("");
        Handler handler = new Handler(Looper.getMainLooper());

        new Thread(() -> {
            try {
                for (char charToAdd : text.toCharArray()) {

                    Thread.sleep(50);

                    handler.post(
                            () -> binding.edittext.getText().append(charToAdd)
                    );
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}