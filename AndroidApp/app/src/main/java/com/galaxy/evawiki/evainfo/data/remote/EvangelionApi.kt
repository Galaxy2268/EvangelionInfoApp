package com.galaxy.evawiki.evainfo.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import com.galaxy.evawiki.evainfo.domain.model.Item

interface EvangelionApi {

    @GET("characters")
    suspend fun getCharacters(): List<Item.Character>

    @GET("characters/id/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Item.Character

    @GET("Angels")
    suspend fun getAngels(): List<Item.Angel>

    @GET("Angels/id/{id}")
    suspend fun getAngel(@Path("id") id: Int): Item.Angel

    @GET("Evangelions")
    suspend fun getEvangelions(): List<Item.Evangelion>

    @GET("Evangelions/id/{id}")
    suspend fun getEvangelion(@Path("id") id: Int): Item.Evangelion

    @GET("Episodes")
    suspend fun getEpisodes(): List<Item.Episode>

    @GET("Episodes/id/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Item.Episode

    @GET("Stuff")
    suspend fun getStuff(): List<Item.Stuff>

    @GET("Stuff/id/{id}")
    suspend fun getSingleStuff(@Path("id") id: Int): Item.Stuff

}