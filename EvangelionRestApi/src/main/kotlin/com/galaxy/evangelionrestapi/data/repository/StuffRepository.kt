package com.galaxy.evangelionrestapi.data.repository

import com.galaxy.evangelionrestapi.domain.model.Stuff
import org.springframework.data.jpa.repository.JpaRepository

interface StuffRepository: JpaRepository<Stuff, Long> {
    fun findByName(name: String): Stuff?
    fun findByPk(pk: Long): Stuff?
}