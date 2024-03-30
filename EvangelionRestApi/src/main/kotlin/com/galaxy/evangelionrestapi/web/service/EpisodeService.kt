package com.galaxy.evangelionrestapi.web.service

import com.galaxy.evangelionrestapi.domain.model.Episode

interface EpisodeService {
    fun getEpisodes(): List<Episode>
    fun getByNumber(number: String): Episode
    fun getByPk(pk: Long): Episode
}