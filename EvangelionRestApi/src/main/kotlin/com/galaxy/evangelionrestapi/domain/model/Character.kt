package com.galaxy.evangelionrestapi.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "characters")
class Character(
    @Id @GeneratedValue
    var pk: Long,
    var name: String,
    var fullName: String,
    var rank: String,
    var age: Int,
    var dateOfBirth: String,
    var bloodType: String,
    var info: String,
    var picture: String
)