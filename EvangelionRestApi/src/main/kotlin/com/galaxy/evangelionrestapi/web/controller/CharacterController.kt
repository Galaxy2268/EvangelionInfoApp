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

    @ExceptionHandler(NullPointerException::class)
    fun handleNull(e: Exception): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @GetMapping("/api/characters")
    fun getCharacters() = characterService.getCharacters()

    @GetMapping("/api/characters/{name}")
    fun getCharacterByName(@PathVariable name: String) = characterService.getByName(name)

}