package com.galaxy.evangelioninfoapp.evangelioninfo.domain.repository

import arrow.core.Either
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.Character
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.NetworkError

interface CharacterRepository {

    suspend fun getCharacters(): Either<NetworkError, List<Character>>

    suspend fun getCharacter(name: String): Either<NetworkError, Character>

}