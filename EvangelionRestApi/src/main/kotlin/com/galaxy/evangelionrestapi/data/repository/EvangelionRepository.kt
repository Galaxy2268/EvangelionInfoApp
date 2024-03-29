package com.galaxy.evangelionrestapi.data.repository

import com.galaxy.evangelionrestapi.domain.model.Evangelion
import org.springframework.data.jpa.repository.JpaRepository

interface EvangelionRepository: JpaRepository<Evangelion, Long>{
    fun findByName(name: String): Evangelion?
    fun findByPk(pk: Long): Evangelion?
}