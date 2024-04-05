package com.galaxy.evawiki.evainfo.presentation.items

import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType

sealed class ItemsEvent {
    data object ToggleOrderSection: ItemsEvent()
    data class GetItems(val itemType: ItemType): ItemsEvent()

}