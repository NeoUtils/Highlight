package com.neoutils.highlight.core

import com.neoutils.highlight.core.util.Matcher

interface Scheme<T : Any> {
    val regex: Regex
    val matcher: Matcher<T>
    val range: IntRange?
}
