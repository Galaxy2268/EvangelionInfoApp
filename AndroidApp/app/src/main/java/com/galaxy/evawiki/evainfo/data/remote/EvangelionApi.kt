package com.galaxy.evawiki.evainfo.data.remote

import com.galaxy.evawiki.evainfo.domain.model.Angel
import retrofit2.http.GET
import retrofit2.http.Path
import com.galaxy.evawiki.evainfo.domain.model.Character
import com.galaxy.evawiki.evainfo.domain.model.Episode
import com.galaxy.evawiki.evainfo.domain.model.Evangelion
import com.galaxy.evawiki.evainfo.domain.model.Stuff

interface EvangelionApi {

    @GET("characters")
    suspend fun getCharacters(): List<Character>

    @GET("characters/id/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Character

    @GET("Angels")
    suspend fun getAngels(): List<Angel>

    @GET("Angels/id/{id}")
    suspend fun getAngel(@Path("id") id: Int): Angel

    @GET("Evangelions")
    suspend fun getEvangelions(): List<Evangelion>

    @GET("Evangelions/id/{id}")
    suspend fun getEvangelion(@Path("id") id: Int): Evangelion

    @GET("Episodes")
    suspend fun getEpisodes(): List<Episode>

    @GET("Episodes/id/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Episode

    @GET("Stuff")
    suspend fun getStuff(): List<Stuff>

    @GET("Stuff/id/{id}")
    suspend fun getSingleStuff(@Path("id") id: Int): Stuff

}