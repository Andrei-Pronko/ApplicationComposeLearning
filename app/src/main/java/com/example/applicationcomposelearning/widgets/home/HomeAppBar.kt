package com.example.applicationcomposelearning.widgets.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.ui.tooling.preview.Preview

@Composable
fun HomeAppBar(
    backgroundColor: Color = MaterialTheme.colors.primary,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(text = "Choose Repaired Asset")
        },
        backgroundColor = backgroundColor,
        actions = {
            Providers(AmbientContentAlpha provides ContentAlpha.high, children = {
                IconButton(
                    onClick = { },
                    icon = { Icon(Icons.Filled.Search) }
                )
                IconButton(
                    onClick = { },
                    icon = { Icon(Icons.Filled.Refresh) }
                )
            })
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HomeAppBarPreview() {
    HomeAppBar()
}