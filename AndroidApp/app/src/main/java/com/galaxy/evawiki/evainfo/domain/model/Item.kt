package com.galaxy.evawiki.evainfo.domain.model

sealed class Item{
    data class Angel(
        val pk: Int,
        val name: String,
        val meaning: String,
        val symbolism: String,
        val number: Int,
        val info: String,
        val picture: String
    ): Item()

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
    ): Item()

    data class Episode(
        val pk: Int,
        val number: String,
        val name: String,
        val director: String,
        val writer: String,
        val airDate: String,
        val info: String,
        val picture: String
    ): Item()

    data class Evangelion(
        val pk: Int,
        val name: String,
        val model: String,
        val pilot: String,
        val soul: String,
        val info: String,
        val picture: String
    ): Item()

    data class Stuff(
        val pk: Int,
        val name: String,
        val info: String,
        val picture: String
    ): Item()


}