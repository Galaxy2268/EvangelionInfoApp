package com.galaxy.evangelionrestapi.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "angels")
class Angel(
    @Id @GeneratedValue
    var pk: Long = 0,
    var name: String = "",
    var meaning: String = "",
    var symboly: String = "",
    var number: Int = 0,
    var info: String = "",
    var picture: String = ""
)