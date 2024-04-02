package com.galaxy.evawiki.evainfo.domain.usecases.angel

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.Angel
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.AngelRepository

class GetAngel(
    private val angelRepository: AngelRepository
) {
    suspend operator fun invoke(id: Int): Either<NetworkError, Angel>{
        return angelRepository.getAngel(id)
    }
}