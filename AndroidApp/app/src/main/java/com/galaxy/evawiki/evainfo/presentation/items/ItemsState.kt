package com.galaxy.evawiki.evainfo.presentation.items

import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.model.Character

data class CharactersState(
    val items: List<Character> = emptyList(),
    val error: NetworkError? = null
)