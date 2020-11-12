@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.example.applicationcomposelearning.widgets.home

import androidx.lifecycle.ViewModel
import com.example.applicationcomposelearning.widgets.home.state.ReplaceAssetElement
import com.example.applicationcomposelearning.widgets.home.state.ReplaceAssetItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TestViewModel : ViewModel() {
    private var internalList = testItems

    private val _replaceAssetItems = MutableStateFlow<List<ReplaceAssetItem>>(internalList)
    val replaceAssetItems: StateFlow<List<ReplaceAssetItem>> = _replaceAssetItems

    fun selectAsset(selectedId: Int) {
        internalList = internalList.map { item ->
            when (item) {
                is ReplaceAssetItem.ReplaceAsset -> {
                    val isSelected = item.replaceAssetElement.id == selectedId
                    item.copy(isSelected = isSelected)
                }
                else -> item
            }
        }.toMutableList()
        _replaceAssetItems.value = internalList
    }
}

private val testItems = mutableListOf(
    ReplaceAssetItem.Title,
    ReplaceAssetItem.ReplaceAsset(
        ReplaceAssetElement(
            1,
            "1234567890",
            "WY9-77834-002",
            "#237-987-32ZY",
            "Trane",
            "ba21",
            "Repaired",
        )
    ),
    ReplaceAssetItem.ReplaceAsset(
        ReplaceAssetElement(
            2,
            "1234567890",
            "WY9-77834-002",
            "#237-987-32ZY",
            "Trane",
            "ba21",
            "Repaired",
        )
    ),
    ReplaceAssetItem.ReplaceAsset(
        ReplaceAssetElement(
            3,
            "1234567890",
            "WY9-77834-002",
            "#237-987-32ZY",
            "Trane",
            "ba21",
            "Repaired",
        )
    ),
    ReplaceAssetItem.ReplaceAsset(
        ReplaceAssetElement(
            4,
            "1234567890",
            "WY9-77834-002",
            "#237-987-32ZY",
            "Trane",
            "ba21",
            "Repaired",
        )
    ),
    ReplaceAssetItem.ReplaceAsset(
        ReplaceAssetElement(
            5,
            "1234567890",
            "WY9-77834-002",
            "#237-987-32ZY",
            "Trane",
            "ba21",
            "Repaired",
        )
    ),
    ReplaceAssetItem.ReplaceAsset(
        ReplaceAssetElement(
            6,
            "1234567890",
            "WY9-77834-002",
            "#237-987-32ZY",
            "Trane",
            "ba21",
            "Repaired",
        )
    ),
    ReplaceAssetItem.ReplaceAsset(
        ReplaceAssetElement(
            7,
            "1234567890",
            "WY9-77834-002",
            "#237-987-32ZY",
            "Trane",
            "ba21",
            "Repaired",
        )
    ),
    ReplaceAssetItem.NewAssetButton
)