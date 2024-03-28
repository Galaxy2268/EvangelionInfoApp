package com.galaxy.evawiki.evainfo.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import com.galaxy.evawiki.evainfo.domain.model.Character

interface EvangelionApi {

    @GET("characters")
    suspend fun getCharacters(): List<Character>

    @GET("characters/name/{name}")
    suspend fun getCharacter(@Path("name") name: String): Character

}