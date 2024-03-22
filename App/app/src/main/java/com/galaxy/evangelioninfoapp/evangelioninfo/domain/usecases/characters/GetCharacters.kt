package com.galaxy.evangelioninfoapp.evangelioninfo.domain.usecases.characters

import arrow.core.Either
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.Character
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.NetworkError
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.repository.CharacterRepository

class GetCharacters(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): Either<NetworkError, List<Character>> {
        return repository.getCharacters()
    }
}