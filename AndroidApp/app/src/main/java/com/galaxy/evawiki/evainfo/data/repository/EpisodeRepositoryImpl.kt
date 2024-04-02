package com.galaxy.evawiki.evainfo.data.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.data.mapper.toNetworkError
import com.galaxy.evawiki.evainfo.data.remote.EvangelionApi
import com.galaxy.evawiki.evainfo.domain.model.Episode
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.EpisodeRepository

class EpisodeRepositoryImpl(
    private val api: EvangelionApi
): EpisodeRepository {
    override suspend fun getEpisodes(): Either<NetworkError, List<Episode>> {
        return Either.catch {
            api.getEpisodes()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getEpisode(id: Int): Either<NetworkError, Episode> {
        return Either.catch {
            api.getEpisode(id)
        }.mapLeft { it.toNetworkError() }
    }
}