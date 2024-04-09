package com.galaxy.evawiki.evainfo.presentation.item

import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.model.NetworkError

data class ItemState(
    val item: Item? = null,
    val networkError: NetworkError? = null
)