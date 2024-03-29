package com.galaxy.evangelionrestapi.web.controller

import com.galaxy.evangelionrestapi.web.service.EvangelionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EvangelionController(
    @Autowired
    private val evangelionService: EvangelionService
) {
    @GetMapping("/api/evangelions")
    fun getEvangelions() = evangelionService.getEvangelions()

    @GetMapping("/api/evangelions/name/{name}")
    fun getEvangelionByName(@PathVariable name: String) = evangelionService.getByName(name)

    @GetMapping("/api/evangelions/id/{pk}")
    fun getEvangelionById(@PathVariable pk: Long) = evangelionService.getByPk(pk)

}