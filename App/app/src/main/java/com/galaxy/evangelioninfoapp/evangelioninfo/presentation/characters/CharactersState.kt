package com.galaxy.evangelioninfoapp.evangelioninfo.presentation.characters

import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.Character
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.NetworkError

data class CharactersState(
    val characters: List<Character> = emptyList(),
    val error: NetworkError? = null
)
