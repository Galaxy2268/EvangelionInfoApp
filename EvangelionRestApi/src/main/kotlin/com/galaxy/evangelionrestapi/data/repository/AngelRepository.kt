package com.galaxy.evangelionrestapi.data.repository

import com.galaxy.evangelionrestapi.domain.model.Angel
import org.springframework.data.jpa.repository.JpaRepository

interface AngelRepository: JpaRepository<Angel, Long> {
    fun findByName(name: String): Angel?
    fun findByPk(pk: Long): Angel?
}