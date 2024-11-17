package com.neoutils.highlight.example.view.example;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.neoutils.highlight.core.Highlight;
import com.neoutils.highlight.core.util.Match;
import com.neoutils.highlight.core.util.UiColor;
import com.neoutils.highlight.view.extension.HighlightKt;
import com.neoutils.highlight.core.scheme.TextColorScheme;
import kotlin.text.Regex;

public class JavaCaseExample extends AppCompatTextView {

    {
        var highlight = new Highlight(
                new TextColorScheme(
                        new Regex("\\bjava\\b"),
                        Match.fully(new UiColor.Integer(Color.RED))
                )
        );

        setText(
                HighlightKt.toSpannedString(
                        highlight,
                        "Example of java"
                )
        );
    }

    public JavaCaseExample(@NonNull Context context) {
        super(context);
    }

    public JavaCaseExample(
            @NonNull Context context,
            @Nullable AttributeSet attrs
    ) {
        super(context, attrs);
    }
}
