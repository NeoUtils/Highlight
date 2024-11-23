package com.neoutils.highlight.core

import com.neoutils.highlight.core.util.Match

interface Scheme<T : Any> {
    val regex: Regex
    val match : Match<T>
    val level: Int
    val tag: String
}
