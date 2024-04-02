package com.galaxy.evawiki.evainfo.data.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.data.mapper.toNetworkError
import com.galaxy.evawiki.evainfo.data.remote.EvangelionApi
import com.galaxy.evawiki.evainfo.domain.model.Angel
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.AngelRepository

class AngelRepositoryImpl(
    private val api: EvangelionApi
): AngelRepository {
    override suspend fun getAngels(): Either<NetworkError, List<Angel>> {
        return Either.catch {
            api.getAngels()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getAngel(id: Int): Either<NetworkError, Angel> {
        return Either.catch {
            api.getAngel(id)
        }.mapLeft { it.toNetworkError() }
    }
}