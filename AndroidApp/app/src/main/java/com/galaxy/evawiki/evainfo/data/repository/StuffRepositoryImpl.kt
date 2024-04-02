package com.galaxy.evawiki.evainfo.data.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.data.mapper.toNetworkError
import com.galaxy.evawiki.evainfo.data.remote.EvangelionApi
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.model.Stuff
import com.galaxy.evawiki.evainfo.domain.repository.StuffRepository

class StuffRepositoryImpl(
    private val api: EvangelionApi
):StuffRepository {
    override suspend fun getStuff(): Either<NetworkError, List<Stuff>> {
        return Either.catch {
            api.getStuff()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getSingleStuff(id: Int): Either<NetworkError, Stuff> {
        return Either.catch {
            api.getSingleStuff(id)
        }.mapLeft { it.toNetworkError() }
    }

}