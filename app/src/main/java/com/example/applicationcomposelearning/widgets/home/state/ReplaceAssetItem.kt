package com.example.applicationcomposelearning.widgets.home.state

sealed class ReplaceAssetItem {
    object Title : ReplaceAssetItem()
    data class ReplaceAsset(
        val replaceAssetElement: ReplaceAssetElement,
        var isSelected: Boolean = false
    ) :
        ReplaceAssetItem()

    object NewAssetButton : ReplaceAssetItem()
}

data class ReplaceAssetElement(
    val id: Int,
    val tagId: String,
    val assetTag: String,
    val serial: String,
    val brand: String,
    val model: String,
    val repairStatus: String,
)

sealed class ReplaceAssetAnswer(open val title: String) {
    class Yes(override val title: String = "Yes") : ReplaceAssetAnswer(title)
    class No(override val title: String = "No") : ReplaceAssetAnswer(title)
}