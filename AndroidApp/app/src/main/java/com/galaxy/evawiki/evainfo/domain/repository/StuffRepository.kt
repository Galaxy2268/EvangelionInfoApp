package com.galaxy.evawiki.evainfo.domain.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.model.Stuff

interface StuffRepository {
    suspend fun getStuff(): Either<NetworkError, List<Stuff>>

    suspend fun getSingleStuff(id: Int): Either<NetworkError, Stuff>
}