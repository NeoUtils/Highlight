package com.neoutils.highlight.example.compose.launcher

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.neoutils.highlight.compose.remember.rememberHighlight
import com.neoutils.highlight.core.extension.textColor
import com.neoutils.highlight.example.compose.R
import com.neoutils.highlight.example.compose.example.CodeHighlightExample
import com.neoutils.highlight.example.compose.theme.ExampleTheme

@OptIn(ExperimentalMaterial3Api::class)
class CodeHighlightExample : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                Color.TRANSPARENT,
            )
        )

        setContent {
            ExampleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(R.string.app_name))
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = colorScheme.primary,
                                titleContentColor = colorScheme.onPrimary
                            )
                        )
                    }
                ) { innerPadding ->
                    CodeHighlightExample(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}
