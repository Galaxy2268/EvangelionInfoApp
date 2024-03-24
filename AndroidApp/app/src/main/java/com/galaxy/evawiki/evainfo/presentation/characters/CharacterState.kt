package com.galaxy.evawiki.evainfo.presentation.characters

import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.model.Character

data class CharactersState(
    val characters: List<Character> = emptyList(),
    val error: NetworkError? = null
)