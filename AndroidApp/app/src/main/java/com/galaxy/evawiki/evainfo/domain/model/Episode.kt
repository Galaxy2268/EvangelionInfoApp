package com.galaxy.evawiki.evainfo.domain.model

data class Episode(
    val pk: Int,
    val number: String,
    val name: String,
    val director: String,
    val writer: String,
    val airDate: String,
    val info: String,
    val picture: String
)
