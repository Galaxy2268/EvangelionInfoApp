package com.galaxy.evawiki.evainfo.domain.usecases.character

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.CharacterRepository
import com.galaxy.evawiki.evainfo.domain.model.Character

class GetCharacters(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(): Either<NetworkError, List<Character>> {
        return characterRepository.getCharacters()
    }
}