package com.galaxy.evangelioninfoapp.evangelioninfo.data.repository

import arrow.core.Either
import com.galaxy.evangelioninfoapp.evangelioninfo.data.mapper.toNetworkError
import com.galaxy.evangelioninfoapp.evangelioninfo.data.remote.EvangelionApi
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.Character
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.NetworkError
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val api: EvangelionApi
): CharacterRepository {
    override suspend fun getCharacters(): Either<NetworkError, List<Character>> {
        return Either.catch {
            api.getCharacters()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getCharacter(name: String): Either<NetworkError, Character> {
        return Either.catch {
            api.getCharacter(name)
        }.mapLeft { it.toNetworkError() }
    }
}