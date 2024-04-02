package com.galaxy.evawiki.evainfo.domain.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.Angel
import com.galaxy.evawiki.evainfo.domain.model.NetworkError

interface AngelRepository {
    suspend fun getAngels(): Either<NetworkError, List<Angel>>

    suspend fun getAngel(id: Int): Either<NetworkError, Angel>
}