package com.galaxy.evawiki.evainfo.domain.usecases.characters

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.CharacterRepository
import com.galaxy.evawiki.evainfo.domain.model.Character

class GetCharacters(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): Either<NetworkError, List<Character>> {
        return repository.getCharacters()
    }
}