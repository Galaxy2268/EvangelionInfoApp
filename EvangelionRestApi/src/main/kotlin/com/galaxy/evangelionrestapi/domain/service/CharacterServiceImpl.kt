package com.galaxy.evangelionrestapi.domain.service

import com.galaxy.evangelionrestapi.data.repository.CharacterRepository
import com.galaxy.evangelionrestapi.domain.model.Character
import com.galaxy.evangelionrestapi.web.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler

@Service
class CharacterServiceImpl(
    @Autowired
    private val characterRepository: CharacterRepository
): CharacterService {

    override fun getByName(name: String): Character {
        val character = characterRepository.findByName(name)
        return character ?: throw NullPointerException("Character not found")
    }

    override fun getCharacters(): List<Character> {
        return characterRepository.findAll()
    }

}