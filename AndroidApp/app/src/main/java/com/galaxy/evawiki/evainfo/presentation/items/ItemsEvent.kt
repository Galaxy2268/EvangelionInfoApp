package com.galaxy.evawiki.evainfo.presentation.items

import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType

sealed class ItemsEvent {
    data object ToggleFilterSection: ItemsEvent()
    data class GetItems(val itemType: ItemType): ItemsEvent()

}