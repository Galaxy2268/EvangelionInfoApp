package com.galaxy.evawiki.evainfo.domain.usecases.evangelion

import com.galaxy.evawiki.evainfo.domain.repository.EvangelionRepository

class GetEvangelions(
    private val evangelionRepository: EvangelionRepository
) {
}