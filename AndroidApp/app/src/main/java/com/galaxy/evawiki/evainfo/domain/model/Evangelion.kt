package com.galaxy.evawiki.evainfo.domain.model

data class Evangelion(
    val pk: Int,
    val name: String,
    val model: String,
    val pilot: String,
    val soul: String,
    val info: String,
    val picture: String
)
