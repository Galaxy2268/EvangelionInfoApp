package com.galaxy.evawiki.evainfo.presentation.items.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType

@Composable
fun FilterSection(
    modifier: Modifier,
    currentItem: ItemType = ItemType.CharacterType,
    onChange: (ItemType) -> Unit
){
    LazyRow(modifier = modifier,) {
        item { 
            ItemRadioButton(
                text = "Characters:",
                selected = currentItem is ItemType.CharacterType,
                onSelect = { onChange(ItemType.CharacterType) }
            )
        }
        item {
            ItemRadioButton(
                text = "Angels:",
                selected = currentItem is ItemType.AngelType,
                onSelect = { onChange(ItemType.AngelType) }
            )
        }
        item {
            ItemRadioButton(
                text = "Evangelions:",
                selected = currentItem is ItemType.EvangelionType,
                onSelect = { onChange(ItemType.EvangelionType) }
            )
        }
        item {
            ItemRadioButton(
                text = "Episodes:",
                selected = currentItem is ItemType.EpisodeType,
                onSelect = { onChange(ItemType.EpisodeType) }
            )
        }
        item {
            ItemRadioButton(
                text = "Stuff:",
                selected = currentItem is ItemType.StuffType,
                onSelect = { onChange(ItemType.StuffType) }
            )
        }


    }

}