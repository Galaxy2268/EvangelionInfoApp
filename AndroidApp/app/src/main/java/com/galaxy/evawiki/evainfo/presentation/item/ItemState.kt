package com.galaxy.evawiki.evainfo.presentation.item

import com.galaxy.evawiki.evainfo.domain.model.Character
import com.galaxy.evawiki.evainfo.domain.model.NetworkError

data class ItemState(
    val item: Character? = null,
    val networkError: NetworkError? = null
)