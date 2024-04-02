package com.galaxy.evawiki.evainfo.domain.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.Evangelion
import com.galaxy.evawiki.evainfo.domain.model.NetworkError

interface EvangelionRepository {
    suspend fun getEvahgelions(): Either<NetworkError, List<Evangelion>>

    suspend fun getEvangelion(id: Int): Either<NetworkError, Evangelion>
}