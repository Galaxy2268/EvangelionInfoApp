package com.galaxy.evangelionrestapi.domain.service

import com.galaxy.evangelionrestapi.data.repository.CharacterRepository
import com.galaxy.evangelionrestapi.domain.model.Character
import com.galaxy.evangelionrestapi.domain.service.util.Path.PICTURE_PATH
import com.galaxy.evangelionrestapi.web.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CharacterServiceImpl(
    @Autowired
    private val characterRepository: CharacterRepository
): CharacterService {

    override fun getByName(name: String): Character {
        val character = characterRepository.findByName(name).also { it?.picture = PICTURE_PATH + it?.picture}
        return character ?: throw NullPointerException("Character not found")
    }

    override fun getCharacters(): List<Character> {
        return characterRepository.findAll().onEach { it.picture = PICTURE_PATH + it.picture }
    }

    override fun getByPk(pk: Long): Character {
        val character = characterRepository.findByPk(pk).also { it?.picture = PICTURE_PATH + it?.picture}
        return character ?: throw NullPointerException("Character not found")
    }

}