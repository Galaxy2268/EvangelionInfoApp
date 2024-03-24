package com.galaxy.evawiki.evainfo.data.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.data.mapper.toNetworkError
import com.galaxy.evawiki.evainfo.data.remote.EvangelionApi
import com.galaxy.evawiki.evainfo.domain.repository.CharacterRepository
import com.galaxy.evawiki.evainfo.domain.model.Character
import com.galaxy.evawiki.evainfo.domain.model.NetworkError

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