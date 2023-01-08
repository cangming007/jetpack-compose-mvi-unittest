package com.cangming.jetpack.ui

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MoviesTheme(colors: Colors = MaterialTheme.colors, content: @Composable () -> Unit) {
    MaterialTheme(colors = colors, content = content)
}