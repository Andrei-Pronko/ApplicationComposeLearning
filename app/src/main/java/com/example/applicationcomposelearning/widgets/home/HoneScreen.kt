package com.example.applicationcomposelearning.widgets.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applicationcomposelearning.widgets.home.state.ReplaceAssetAnswer

@Composable
fun HomeScreen() {
    val answers = listOf(ReplaceAssetAnswer.Yes(), ReplaceAssetAnswer.No())
    Column {
        HomeAppBar(modifier = Modifier.height(56.dp).fillMaxWidth())
        HomeContent(answers)
    }
}