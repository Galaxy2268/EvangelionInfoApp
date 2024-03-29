package com.galaxy.evangelionrestapi.web.controller

import com.galaxy.evangelionrestapi.web.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CharacterController(
    @Autowired
    private val characterService: CharacterService
) {


    @GetMapping("/api/characters")
    fun getCharacters() = characterService.getCharacters()

    @GetMapping("/api/characters/name/{name}")
    fun getCharacterByName(@PathVariable name: String) = characterService.getByName(name)

    @GetMapping("/api/characters/id/{pk}")
    fun getCharacterById(@PathVariable pk: Long) = characterService.getByPk(pk)

}