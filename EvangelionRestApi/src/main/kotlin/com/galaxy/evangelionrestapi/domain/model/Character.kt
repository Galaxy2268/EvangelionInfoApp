package com.galaxy.evangelionrestapi.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "characters")
class Character(
    @Id @GeneratedValue
    var id: Long = 0,
    var name: String = "",
    var rank: String = "",
    var age: Int = 0,
    var dateOfBirth: String = "",
    var bloodType: String = "",
    var bio: String = "",
    var picture: String = ""
)