package com.neoutils.highlight.core

interface Scheme<T : Any> {
    val regex: Regex
    val values: List<T?>
}
