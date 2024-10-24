package com.neoutils.highlight.example.view.example;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.neoutils.highlight.core.Highlight;
import com.neoutils.highlight.core.utils.Match;
import com.neoutils.highlight.view.extension.SpannedStringKt;
import com.neoutils.highlight.view.scheme.TextColorScheme;
import com.neoutils.highlight.view.util.UiColor;
import kotlin.text.Regex;

public class JavaCaseExample extends AppCompatTextView {

    public JavaCaseExample(@NonNull Context context) {
        super(context);

        init();
    }

    public JavaCaseExample(
            @NonNull Context context,
            @Nullable AttributeSet attrs
    ) {
        super(context, attrs);

        init();
    }

    private void init() {
        var highlight = new Highlight(
                new TextColorScheme(
                        new Regex("(java)"),
                        Match.fully(new UiColor(Color.RED))
                )
        );

        setText(
                SpannedStringKt.toSpannedString(
                        highlight,
                        "Example of java"
                )
        );
    }
}