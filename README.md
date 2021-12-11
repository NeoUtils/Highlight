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
        ),
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
        ).setClearOldSpan(true),
        new StyleScheme(
                Pattern.compile("\\b([Kk])otlin\\b"),
                StyleScheme.STYLE.BOLD_ITALIC
        ).setClearOldSpan(true)
);

//add the listener
binding.edittext.addTextChangedListener(highlightTextWatcher);
```
## Schemes
Use the default schemes; `ColorScheme`, `OnBackgroundScheme`, `StyleScheme`, `FontScheme`, `LinkScheme` and `OnClickScheme`, or implement the `Scheme` interface to create a custom scheme.

``` java
...

highlight.addScheme(
        new StyleScheme(
                Pattern.compile("Highlight"),
                StyleScheme.STYLE.BOLD_ITALIC
        ).addScopeScheme(
                //scheme in scope of other schemes
                new ColorScheme(
                        Pattern.compile("light"),
                        Color.parseColor("#FF03DAC5")
                )
        )
);

highlight.addScheme(
        //clickable links
        new LinkScheme().setPainTextUnderline(false)
);

highlight.addScheme(
        //clickable text
        new OnClickScheme(
                Pattern.compile("Highlight"),
                new OnClickScheme.OnClickListener() {
                    @Override
                    public void onClick(CharSequence text) {
                        goToURL("https://github.com/Irineu333/Highlight");
                    }
                }
        )
);

highlight.addScheme(
        new ColorScheme(
                Pattern.compile("Project"),
                Color.BLACK
        ).addScopeScheme(
                //font scheme
                new FontScheme(
                        FontScheme.getFont(this, R.font.pacifico_regular)
                )
        )
);

...
```

## SchemeScope

Every schema has a scope to which other schemas can be added via the `addScopeScheme (...)` method. Schemes added to a scope will run only within that scope, saving processing and creating possibilities for smarter highlights.

``` java
Highlight highlight = new Highlight();

highlight.addScheme(
        new StyleScheme(
                Pattern.compile("Highlight"),
                StyleScheme.STYLE.BOLD_ITALIC
        ).addScopeScheme(
                //add scheme scope in any scheme
                new ColorScheme(
                        Pattern.compile("light"),
                        Color.parseColor("#FF03DAC5")
                )
        )
);

highlight.addScheme(
        //use scope to group schemes
        new Scope(Pattern.compile("Project"),
                new ColorScheme(Color.BLACK),
                new FontScheme(FontScheme.getFont(this, R.font.pacifico_regular))
        )
);

highlight.setSpan(binding.toolbarTitle);
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
