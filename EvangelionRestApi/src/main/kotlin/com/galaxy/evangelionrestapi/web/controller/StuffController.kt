package com.galaxy.evangelionrestapi.web.controller

import com.galaxy.evangelionrestapi.web.service.StuffService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StuffController(
    @Autowired
    private val stuffService: StuffService
) {
    @GetMapping("/api/stuff")
    fun getStuff() = stuffService.getStuff()

    @GetMapping("/api/stuff/name/{name}")
    fun getStuffByName(@PathVariable name: String) = stuffService.geByName(name)

    @GetMapping("/api/stuff/id/{pk}")
    fun getStuffById(@PathVariable pk: Long) = stuffService.getByPk(pk)
}