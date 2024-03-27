package com.galaxy.evangelionrestapi.web.controller

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ResponseBody
class PreviewController {
    @GetMapping("/api")
    fun preview(): ResponseEntity<Resource> {
        val htmlResource: Resource = ClassPathResource("/static/html/Preview.html")
        return ResponseEntity.ok().body(htmlResource)
    }
}