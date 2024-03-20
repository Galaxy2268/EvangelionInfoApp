package com.galaxy.evangelioninfoapp.evangelioninfo.domain.model

data class Character(
    val id: Long,
    val name: String,
    val fullName: String,
    val rank: String,
    val age: Int,
    val dateOfBirth: String,
    val bloodType: String,
    val bio: String,
    val picture: String
)