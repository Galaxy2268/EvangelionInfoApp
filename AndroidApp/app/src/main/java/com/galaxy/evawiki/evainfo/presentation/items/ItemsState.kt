package com.galaxy.evawiki.evainfo.presentation.items

import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.model.Item

data class CharactersState(
    val items: List<Item> = emptyList(),
    val error: NetworkError? = null,
    val isOrderSectionVisible: Boolean = false
)