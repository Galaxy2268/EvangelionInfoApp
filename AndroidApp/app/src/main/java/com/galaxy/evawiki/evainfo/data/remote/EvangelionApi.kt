package com.galaxy.evawiki.evainfo.data.remote

import com.galaxy.evawiki.evainfo.domain.model.Item
import retrofit2.http.GET
import retrofit2.http.Path

interface EvangelionApi {

    @GET("characters")
    suspend fun getCharacters(): List<Item.Character>

    @GET("characters/id/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Item.Character

    @GET("angels")
    suspend fun getAngels(): List<Item.Angel>

    @GET("angels/id/{id}")
    suspend fun getAngel(@Path("id") id: Int): Item.Angel

    @GET("evangelions")
    suspend fun getEvangelions(): List<Item.Evangelion>

    @GET("evangelions/id/{id}")
    suspend fun getEvangelion(@Path("id") id: Int): Item.Evangelion

    @GET("episodes")
    suspend fun getEpisodes(): List<Item.Episode>

    @GET("episodes/id/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Item.Episode

    @GET("stuff")
    suspend fun getStuff(): List<Item.Stuff>

    @GET("stuff/id/{id}")
    suspend fun getSingleStuff(@Path("id") id: Int): Item.Stuff

}