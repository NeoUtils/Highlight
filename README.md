# Highlight [![](https://jitpack.io/v/Irineu333/Highlight.svg)](https://jitpack.io/#Irineu333/Highlight) [![Android CI](https://github.com/Irineu333/Highlight/actions/workflows/android.yml/badge.svg)](https://github.com/Irineu333/Highlight/actions/workflows/android.yml)

A complete and performing library to highlight text snippets (EditText/Editable and TextView) using `Spannable` with Regular Expressions (Regex) for Android.

## Highlight a text
To highlight a text, just create an instance of `Highlight`, add the Schemes and use `setSpan()` method to add to a `TextView` or `EditText`.

``` java
//create an instance of Highlight
Highlight highlight = new Highlight();

//add Schemes
highlight.addScheme(
        new ColorScheme(
                Pattern.compile("\\b([Jj])ava\\b"),
                Color.parseColor("#FC0400")
        )
);

highlight.addScheme(
        new ColorScheme(
                Pattern.compile("\\b([Kk])otlin\\b"),
                Color.parseColor("#FC8500")
        )
);

//highlight the text
highlight.setSpan(binding.edittext);
highlight.setSpan(binding.textview);
```

## Continuously highlight
To continuously highlight an `EditText` whenever it is edited, create an instance of `HighlightTextWatcher`, add the Schemes and add the listener to the `EditText`.

``` java
//create an instance of HighlightTextWatcher
HighlightTextWatcher highlightTextWatcher = new HighlightTextWatcher();

//add schemes
highlightTextWatcher.addScheme(
        new StyleScheme(
                Pattern.compile("\\b([Jj])ava\\b"),
                StyleScheme.STYLE.BOLD_ITALIC
        ).setClearOldSpan(true)
);

highlightTextWatcher.addScheme(
        new StyleScheme(
                Pattern.compile("\\b([Kk])otlin\\b"),
                StyleScheme.STYLE.BOLD_ITALIC
        ).setClearOldSpan(true)
);

//add the listener
binding.edittext.addTextChangedListener(highlightTextWatcher);
```
## Add to project


Add the jitpack to project in build.gradle or settings.gradle (gradle 7+)
``` groovy
maven { url 'https://jitpack.io' }
```

Add the dependence to module (normally app)
``` groovy
implementation "com.github.Irineu333:Highlight:$highlight_version"
```
