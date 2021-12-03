# Highlight [![](https://jitpack.io/v/Irineu333/Highlight.svg)](https://jitpack.io/#Irineu333/Highlight) [![Android CI](https://github.com/Irineu333/Highlight/actions/workflows/android.yml/badge.svg)](https://github.com/Irineu333/Highlight/actions/workflows/android.yml)

Uma biblioteca completa e performática para destacar trechos de textos usando `Spannable` com Expressões Regulares (Regex) para Android totalmente em Java.

### Processamento por linhas alteradas (opcional)
Quando ativado (por padrão é), a classe ``HighlightTextWatcher`` processa apenas as linhas alteradas e não todo o texto, melhorando consideravelmente a performance. Mas você pode desabilitar essa funcionalidade com ``setRange(HighlightTextWatcher.RANGE_PROCESS.MODIFIED);``

### Por que em Java?
Para maior compatibilidade... Mas você pode utilizar em Kotlin.

## Como usar

A forma mais básica de utilizar a lib é com as implementações padrões, como ``HighlightTextWatcher`` e os ``Scheme`` (``ColorScheme``, ``StyleScheme`` etc.)
``` java
//crie uma instância de Hightlight
Highlight highlight = new Highlight();

//adicione seus Scheme, a lib possui alguns prontos
highlight.addScheme(
        new ColorScheme(
                "\\b(J|j)ava\\b",
                Color.parseColor("#FC0400")
        )
);

highlight.addScheme(
        new ColorScheme(
                "\\b(K|k)otlin\\b",
                Color.parseColor("#FC8500")
        )
);

//crie uma HighlightTextWatcher passando a instância de Highlight pelo construtor
HighlightTextWatcher textWatcher = new HighlightTextWatcher(highlight);

//adicione o HighlightTextWatcher ao EditText
binding.edittext.addTextChangedListener(textWatcher);
 ```
 
 Mais você pode fazer suas próprias implementações, por exemplo estendendo a classe ``LinesTextWatcher`` que fornece o processamento por linhas alteradas ou criar seus próprios ``Scheme``, apenas estendendo a interface Scheme e implementando os métodos.
``` java
//custom scheme example
highlight.addScheme(
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

//para que a classe Hightlight saiba remover esse span
highlight.addSpanType(StrikethroughSpan.class);
```

A classe ``Highlight`` possui as implementaçõs de adicionar e remover spans em todo ``Editable`` ou apenas em trechos específicos, você pode usá-la idividualmente também.

``` java
highlight.removeSpan(editable, start, end);
highlight.setSpan(editable, start, end);

highlight.removeSpan(editable);
highlight.setSpan(editable);
```

## Adicionar a seu projeto


Adicione o jitpack a seu projeto em settings.gradle
``` groovy
maven { url 'https://jitpack.io' }
```

Adicione a dependencia ao gradle do módulo (geralmente o módulo app)
``` groovy
implementation 'com.github.Irineu333:Highlight:version'
```
