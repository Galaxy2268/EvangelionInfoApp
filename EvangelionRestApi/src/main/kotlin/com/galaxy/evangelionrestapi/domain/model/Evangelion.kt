package com.galaxy.evangelionrestapi.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "evangelions")
class Evangelion(
    @Id @GeneratedValue
    var pk: Long,
    var name: String,
    var model: String,
    var pilot: String,
    var soul: String,
    var info: String,
    var picture: String
)