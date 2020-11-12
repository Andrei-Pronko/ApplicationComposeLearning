@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.example.applicationcomposelearning.widgets.home

import androidx.compose.animation.animate
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.example.applicationcomposelearning.R
import com.example.applicationcomposelearning.widgets.home.state.ReplaceAssetItem

@Composable
fun ReplaceAssetItemWidget() {
    val viewModel: TestViewModel = viewModel()
    val state = viewModel.replaceAssetItems.collectAsState()
    LazyColumnFor(items = state.value) { item ->
        when (item) {
            is ReplaceAssetItem.Title -> {
                ReplaceAssetItemTitle()
            }
            is ReplaceAssetItem.ReplaceAsset -> {
                ReplaceAssetItemReplaceAsset(item)
            }
            is ReplaceAssetItem.NewAssetButton -> {
                ReplaceAssetItemNewAssetButton()
            }
        }
    }
}

@Composable
fun ReplaceAssetItemTitle() {
    Surface(modifier = Modifier.padding(8.dp).fillMaxWidth(), color = Color.LightGray) {
        Row {
            Text("Please scan or select the replacement asset")
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ReplaceAssetItemReplaceAsset(replaceAssetItem: ReplaceAssetItem.ReplaceAsset) {
    val viewModel: TestViewModel = viewModel()
    val item = replaceAssetItem.replaceAssetElement
    val itemColor = when (replaceAssetItem.isSelected) {
        true -> Color.Blue
        false -> Color.White
    }
    val itemClickable = Modifier.clickable(onClick = {
        viewModel.selectAsset(item.id)
    })
    Surface(color = animate(target = itemColor)) {
        Column(modifier = itemClickable) {
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(4.dp).fillMaxWidth())
            AssetLineWidget("Tag ID", item.tagId)
            AssetLineWidget("Asset Tag", item.assetTag)
            AssetLineWidget("Serial", item.serial)
            AssetLineWidget("Brand", item.brand)
            AssetLineWidget("Model", item.model)
            AssetLineWidget("Repair status", item.repairStatus)
            Spacer(modifier = Modifier.height(4.dp).fillMaxWidth())
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun ReplaceAssetItemNewAssetButton() {
    Column {
        Divider(color = Color.LightGray, thickness = 8.dp)
        Surface(color = Color.White) {
            Row {
                Text(
                    modifier = Modifier.padding(all = 8.dp),
                    text = stringResource(id = R.string.cant_find_asset_add_new),
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Divider(color = Color.LightGray, thickness = 96.dp)
    }
}

@Composable
fun AssetLineWidget(firstText: String, secondText: String) {
    Row {
        Text(modifier = Modifier.padding(start = 8.dp), text = firstText)
        Spacer(modifier = Modifier.weight(1f))
        Text(modifier = Modifier.padding(end = 8.dp), text = secondText)
    }
}