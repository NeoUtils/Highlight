package com.neoutils.highlight.core

data class Range<T : Any>(
    val start: Int,
    val end: Int,
    val level: Int,
    val tag: String,
    val item: T
)
