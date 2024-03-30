package com.galaxy.evangelionrestapi.web.controller

import com.galaxy.evangelionrestapi.web.service.AngelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AngelController(
    @Autowired
    private val angelService: AngelService
) {
    @GetMapping("/api/angels")
    fun getAngels() = angelService.getAngels()

    @GetMapping("/api/angels/name/{name}")
    fun getAngelByName(@PathVariable name: String) = angelService.getByName(name)

    @GetMapping("/api/angels/id/{pk}")
    fun getAngelById(@PathVariable pk: Long) = angelService.getByPk(pk)

}