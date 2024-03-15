package com.galaxy.evangelionrestapi.domain.service

import com.galaxy.evangelionrestapi.data.repository.CharacterRepository
import com.galaxy.evangelionrestapi.domain.model.Character
import com.galaxy.evangelionrestapi.web.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CharacterServiceImpl(
    @Autowired
    private val characterRepository: CharacterRepository
): CharacterService {
    override fun getByName(name: String): Character? {
        return characterRepository.findByName(name)
    }

    override fun getCharacters(): List<Character> {
        return characterRepository.findAll()
    }

}