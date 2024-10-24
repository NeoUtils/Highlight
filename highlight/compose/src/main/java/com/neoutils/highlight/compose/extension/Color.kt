package com.neoutils.highlight.compose.extension

import androidx.compose.ui.graphics.Color

operator fun Color.Companion.invoke(hex: String) = Color(android.graphics.Color.parseColor(hex))
