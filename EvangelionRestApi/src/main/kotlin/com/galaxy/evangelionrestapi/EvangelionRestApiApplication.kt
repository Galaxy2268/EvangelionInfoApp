package com.galaxy.evangelionrestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class EvangelionRestApiApplication

fun main(args: Array<String>) {
    runApplication<EvangelionRestApiApplication>(*args)
}
