package com.neo.highlight.util.listener;

import android.text.Editable;

import androidx.annotation.NonNull;

import com.neo.highlight.core.Highlight;
import com.neo.highlight.core.LinesTextWatcher;

/**
 * @author Irineu A. Silva
 */
public class HighlightTextWatcher extends LinesTextWatcher {

    @NonNull
    private RANGE_PROCESS range = RANGE_PROCESS.MODIFIED;

    @NonNull
    private Highlight highlight;

    public HighlightTextWatcher() {
        highlight = new Highlight();
    }

    public HighlightTextWatcher(@NonNull Highlight highlight) {
        this.highlight = highlight;
    }

    @Override
    protected void onLinesChange(
            @NonNull Editable editable,
            int start, int end,
            int firstLineStart, int lastLineEnd
    ) {

        if (range == RANGE_PROCESS.MODIFIED) {
            highlight.removeSpan(editable, firstLineStart, lastLineEnd);
            highlight.setSpan(editable, firstLineStart, lastLineEnd);
        } else {
            highlight.removeSpan(editable);
            highlight.setSpan(editable);
        }

    }

    public void setRange(@NonNull RANGE_PROCESS range) {
        this.range = range;
    }

    @NonNull
    public Highlight getHighlight() {
        return highlight;
    }

    public void setHighlight(@NonNull Highlight highlight) {
        this.highlight = highlight;
    }

    enum RANGE_PROCESS {
        MODIFIED,
        ALL
    }
}
