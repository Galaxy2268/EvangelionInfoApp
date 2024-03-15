package com.galaxy.evangelionrestapi.data.repository

import com.galaxy.evangelionrestapi.domain.model.Character
import org.springframework.data.jpa.repository.JpaRepository

interface CharacterRepository: JpaRepository<Character, Long>{
    fun findByName(name: String): Character?
}