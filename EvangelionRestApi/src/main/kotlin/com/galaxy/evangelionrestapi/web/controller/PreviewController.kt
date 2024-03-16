package com.galaxy.evangelionrestapi.web.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PreviewController {
    @GetMapping("/api")
    fun preview(): ResponseEntity<String> {
        val message = "Evangelion REST API is running!"
        return ResponseEntity.ok(message)
    }
}