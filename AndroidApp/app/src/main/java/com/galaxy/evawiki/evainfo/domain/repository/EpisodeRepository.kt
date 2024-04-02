package com.galaxy.evawiki.evainfo.domain.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.Episode
import com.galaxy.evawiki.evainfo.domain.model.NetworkError

interface EpisodeRepository {
    suspend fun getEpisodes(): Either<NetworkError, List<Episode>>

    suspend fun getEpisode(id: Int): Either<NetworkError, Episode>
}