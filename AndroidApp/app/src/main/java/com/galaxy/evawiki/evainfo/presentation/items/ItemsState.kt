package com.galaxy.evawiki.evainfo.presentation.items

import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType

data class CharactersState(
    val items: List<Item> = emptyList(),
    val error: NetworkError? = null,
    val isFilterSectionVisible: Boolean = false,
    val currentItem: ItemType = ItemType.CharacterType
)