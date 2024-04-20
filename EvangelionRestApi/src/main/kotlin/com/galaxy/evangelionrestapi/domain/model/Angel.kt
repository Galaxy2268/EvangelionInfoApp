package com.galaxy.evangelionrestapi.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "angels")
class Angel(
    @Id @GeneratedValue
    var pk: Long,
    var name: String,
    var meaning: String,
    var symbolism: String,
    var number: String,
    var info: String,
    var picture: String
)