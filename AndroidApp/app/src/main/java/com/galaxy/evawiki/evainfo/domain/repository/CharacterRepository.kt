package com.galaxy.evawiki.evainfo.domain.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.model.Character

interface CharacterRepository {

    suspend fun getCharacters(): Either<NetworkError, List<Character>>

    suspend fun getCharacter(id: Int): Either<NetworkError, Character>

}