package com.galaxy.evangelionrestapi.web.controller

import com.galaxy.evangelionrestapi.web.service.EpisodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EpisodeController(
    @Autowired
    private val episodeService: EpisodeService
) {
    @GetMapping("/api/episodes")
    fun getEpisodes() = episodeService.getEpisodes()

    @GetMapping("/api/episodes/number/{number}")
    fun getEpisodeByName(@PathVariable number: String) = episodeService.getByNumber(number)

    @GetMapping("/api/episodes/id/{pk}")
    fun getEpisodeById(@PathVariable pk: Long) = episodeService.getByPk(pk)
}