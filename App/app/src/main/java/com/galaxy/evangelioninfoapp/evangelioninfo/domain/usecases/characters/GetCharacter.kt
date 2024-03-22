package com.galaxy.evangelioninfoapp.evangelioninfo.domain.usecases.characters

import arrow.core.Either
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.Character
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.NetworkError
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.repository.CharacterRepository

class GetCharacter(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(name: String): Either<NetworkError, Character>{
        return repository.getCharacter(name)
    }
}