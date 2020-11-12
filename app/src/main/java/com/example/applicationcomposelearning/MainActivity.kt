package com.example.applicationcomposelearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.example.applicationcomposelearning.widgets.home.HomeScreen
import com.example.applicationcomposelearning.ui.ApplicationComposeLearningTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationComposeLearningTheme {
                HomeScreen()
            }
        }
    }
}