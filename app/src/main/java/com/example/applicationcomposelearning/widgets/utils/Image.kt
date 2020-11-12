package com.example.applicationcomposelearning.widgets.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.graphics.asImageAsset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.core.graphics.drawable.toBitmap
import coil.imageLoader
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun CoilImage(modifier: Modifier, imageUrl: String) {
    val context = ContextAmbient.current
    val imageState = remember(imageUrl) { mutableStateOf<ImageAsset?>(null) }
    LaunchedEffect(imageUrl) {
        val request = ImageRequest.Builder(context).data(imageUrl).build()
        imageState.value = try {
            val urlDrawable = withContext(Dispatchers.IO) {
                val imageResult = context.imageLoader.execute(request)
                imageResult.drawable
            }
            when (urlDrawable) {
                null -> null
                else -> urlDrawable.toBitmap().asImageAsset()
            }
        } catch (e: Throwable) {
            null
        }
    }
    imageState.value?.let { imageAsset ->
        Image(
            asset = imageAsset,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}