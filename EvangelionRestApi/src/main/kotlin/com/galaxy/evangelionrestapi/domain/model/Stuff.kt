package com.galaxy.evangelionrestapi.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "stuff")
class Stuff(
    @Id @GeneratedValue
    var pk: Long = 0,
    var name: String = "",
    var info: String = "",
    var picture: String = ""
)