package com.neoutils.highlight.core

data class SpanRange<T : Any>(
    val start: Int,
    val end: Int,
    val level: Int,
    val item: T?
)
