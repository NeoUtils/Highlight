package com.neoutils.highlight.example.compose.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.neoutils.highlight.example.compose.exemple.CodeHighlightExample
import com.neoutils.highlight.example.compose.theme.HighlightTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HighlightTheme(darkTheme = false) {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    CodeHighlightExample(
                        modifier = Modifier.padding(
                            innerPadding
                        ).fillMaxSize()
                    )
                }
            }
        }
    }
}
