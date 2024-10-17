package com.neoutils.highlight.core

import com.neoutils.highlight.core.utils.Match

interface Scheme<T : Any> {
    val regex: Regex
    val match : Match<T>
}
