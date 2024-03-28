package com.galaxy.evangelionrestapi.web.controller

import com.galaxy.evangelionrestapi.web.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
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

    @GetMapping("/api/characters/id/{id}")
    fun getCharacterById(@PathVariable id: Long) = characterService.getById(id)

}