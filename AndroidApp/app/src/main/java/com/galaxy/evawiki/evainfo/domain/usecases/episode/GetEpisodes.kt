package com.galaxy.evawiki.evainfo.domain.usecases.episode

import com.galaxy.evawiki.evainfo.domain.repository.EpisodeRepository

class GetEpisodes(
    private val episodeRepository: EpisodeRepository
) {
}