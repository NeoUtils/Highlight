package com.neoutils.highlight.core.util

fun regex(scope: RegexScope.() -> Unit): Regex {

    return RegexScopeImpl().apply(scope).pattern.toRegex()
}

interface RegexScope {
    fun wordBoundary()
    fun wordBoundary(scope: RegexScope.() -> Unit)
    fun word(text: String)
    fun group(scope: RegexScope.() -> Unit)
    fun anyLetter(any: AnyLetter = AnyLetter.One)
}

sealed class AnyLetter {
    data object One: AnyLetter()
    data object Whatever: AnyLetter()
    data object Many: AnyLetter()
    data class Quantity(val number: Int): AnyLetter()
}


class RegexScopeImpl : RegexScope {

    private val build = mutableListOf<String>()
    val pattern get() = build.joinToString(separator = "")

    override fun wordBoundary() {
        build.add("\\b")
    }

    override fun wordBoundary(scope: RegexScope.() -> Unit) {
        wordBoundary()
        build.add(RegexScopeImpl().apply(scope).pattern)
        wordBoundary()
    }

    override fun word(text: String) {
        build.add(text)
    }

    override fun group(scope: RegexScope.() -> Unit) {
        build.add("(")
        build.add(RegexScopeImpl().apply(scope).pattern)
        build.add(")")
    }

    override fun anyLetter(any: RegexScope.Any) {
        when(any) {
            RegexScope.Any.Many -> {
                build.add("\\w+")
            }
            RegexScope.Any.One -> {
                build.add("\\w")
            }
            RegexScope.Any.Whatever -> {
                build.add("\\w*")
            }
            is RegexScope.Any.Quantity -> {
                build.add("\\w{${any.number}}")
            }
        }
    }
}
