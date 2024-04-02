package com.galaxy.evawiki.evainfo.domain.model

data class Character(
    val pk: Int,
    val name: String,
    val fullName: String,
    val rank: String,
    val age: Int,
    val dateOfBirth: String,
    val bloodType: String,
    val bio: String,
    val picture: String
)
