package com.galaxy.evawiki.evainfo.domain.usecases.character

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.CharacterRepository
import com.galaxy.evawiki.evainfo.domain.model.Character

class GetCharacter(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(name: String): Either<NetworkError, Character> {
        return repository.getCharacter(name)
    }
}