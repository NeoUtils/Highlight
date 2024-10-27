# Highlight

Highlight text snippets in **Jetpack Compose** or **View-based** using regular expressions.

## Objective

Facilitate the creation of dynamic highlights using regular expressions, useful for creating code editors or text editors with custom formatting.

## Quick Start

The central class is `Highlight`, from which highlighted texts are generated in formats like `SpannedString` for View-based or `AnnotatedString` for Jetpack Compose, from schemes defined by `Scheme<*>`.

**Usage Example**

``` kotlin
val highlight = Highlight(
    SpanStyleScheme(
        regex = "(styled)".toRegex(),
        match = Match.fully(
            SpanStyle(
                color = Color.White,
                background = Color.Black,
                fontStyle = FontStyle.Italic,
            )
        )
    )
)

// Jetpack Compose
val text = highlight.toAnnotatedString("Example of styled text.")

// View-based
val text = highlight.toSpannedString("Example of styled text.")
```

You can also use extensions to simplify the creation of highlights:

``` kotlin
val highlight = highlight {
    textColor {
        fully(
            regex = "(styled)",
            SpanStyle(
                color = Color.White,
                background = Color.Black,
                fontStyle = FontStyle.Italic,
            )
        )
    }
}
```

## Jetpack Compose

In Jetpack Compose, work with `AnnotatedString` or `TextFieldValue` to integrate the highlight into your layout.

**Usage Example**

``` kotlin
val highlight = rememberHighlight {
    spanStyle {
        fully(
            regex = "color",
            value = UiColor.Blue
        )
    }
}

// AnnotatedString
Text(
    text = highlight.rememberAnnotatedString(
        text = "Example of foreground color."
    )
)

// TextFieldValue
val textFieldValue = rememberSaveable { mutableStateOf(TextFieldValue()) }

BasicTextField(
    value = highlight.rememberTextFieldValue(
       value = textFieldValue.value
    ).copy(
        composition = null
    ),
    onValueChange = {
        textFieldValue.value = it
    }
)
```

## View-based

In View-based environments, work with `SpannedString`, `Editable`, or `SpannableString` to apply the highlights.

**Usage Example**

``` kotlin
val highlight = highlight {
    backgroundColor {
        fully(
            regex = "color",
            UiColor.Blue
        )
    }
    textColor {
        fully(
            regex = "color",
            UiColor.White
        )
    }
}

// TextView
binding.tvExample.text = highlight.toSpannedString(
    text = "Example of background color."
)

// EditText (Editable or Spannable)
highlight.apply(binding.etExample)
```

## Java Support

Although the library was rewritten in Kotlin, it can be used in Java without any issues.

**Usage Example**

``` java
Highlight highlight = new Highlight(
    new TextColorScheme(
        new Regex("(java)"),
        Match.fully(new UiColor(Color.RED))
    )
);

binding.setText(
    HighlightKt.toSpannedString(
        highlight,
        "Example of java"
    )
);
```

## Groups

Instead of applying the highlight to the entire match using `Match.fully(..)`, you can separate it by groups, allowing for more complex highlights.

**Usage Example**

``` kotlin
val highlight = rememberHighlight {
    textColor {
        groups(
            regex = "(\w+)\s*=\s*(\w+)",
            Color.Blue,
            Color.Green
        )
    }
}

Text(
    text = highlight.rememberAnnotatedString(
        "name = Highlight"
    )
)
```
