package com.galaxy.evangelionrestapi.web.service

import com.galaxy.evangelionrestapi.domain.model.Character

interface CharacterService {
    fun getByName(name: String): Character
    fun getCharacters(): List<Character>
    fun getById(id: Long): Character
}