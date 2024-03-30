package com.galaxy.evangelionrestapi.data.repository

import com.galaxy.evangelionrestapi.domain.model.Episode
import org.springframework.data.jpa.repository.JpaRepository

interface EpisodeRepository: JpaRepository<Episode, Long>{
    fun findByNumber(number: String): Episode?
    fun findByPk(pk: Long): Episode?
}