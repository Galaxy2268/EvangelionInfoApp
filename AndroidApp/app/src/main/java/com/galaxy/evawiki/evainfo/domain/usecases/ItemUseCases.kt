package com.galaxy.evawiki.evainfo.domain.usecases

import com.galaxy.evawiki.evainfo.domain.usecases.characters.GetCharacter
import com.galaxy.evawiki.evainfo.domain.usecases.characters.GetCharacters

data class ItemUseCases(
    val getCharacters: GetCharacters,
    val getCharacter: GetCharacter
)