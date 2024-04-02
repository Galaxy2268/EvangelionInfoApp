package com.galaxy.evawiki.evainfo.data.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.data.mapper.toNetworkError
import com.galaxy.evawiki.evainfo.data.remote.EvangelionApi
import com.galaxy.evawiki.evainfo.domain.model.Evangelion
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.EvangelionRepository

class EvangelionRepositoryImpl(
    private val api: EvangelionApi
): EvangelionRepository {
    override suspend fun getEvahgelions(): Either<NetworkError, List<Evangelion>> {
        return Either.catch {
            api.getEvangelions()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getEvangelion(id: Int): Either<NetworkError, Evangelion> {
        return Either.catch {
            api.getEvangelion(id)
        }.mapLeft { it.toNetworkError() }
    }

}