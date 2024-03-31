package com.galaxy.evangelionrestapi.domain.service

import com.galaxy.evangelionrestapi.data.repository.EpisodeRepository
import com.galaxy.evangelionrestapi.domain.model.Episode
import com.galaxy.evangelionrestapi.domain.service.util.Path.PICTURE_PATH
import com.galaxy.evangelionrestapi.web.service.EpisodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EpisodeServiceImpl(
    @Autowired
    private val episodeRepository: EpisodeRepository
): EpisodeService {
    override fun getEpisodes(): List<Episode> {
        return episodeRepository.findAll().onEach { it.picture = PICTURE_PATH + it.picture }
    }

    override fun getByNumber(number: String): Episode {
        val episode = episodeRepository.findByNumber(number).also { it?.picture = PICTURE_PATH + it?.picture}
        return episode ?: throw NullPointerException("Episode not found")
    }

    override fun getByPk(pk: Long): Episode {
        val episode = episodeRepository.findByPk(pk).also { it?.picture = PICTURE_PATH + it?.picture}
        return episode ?: throw NullPointerException("Episode not found")
    }
}