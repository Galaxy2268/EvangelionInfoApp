package com.galaxy.evangelionrestapi.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "episodes")
class Episode(
    @Id @GeneratedValue
    var pk: Long,
    var number: String,
    var name: String,
    var director: String,
    var writer: String,
    var airDate: String,
    var info: String,
    var picture: String
)