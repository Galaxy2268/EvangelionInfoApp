package com.galaxy.evangelioninfoapp.evangelioninfo.data.remote

import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.Character
import retrofit2.http.GET
import retrofit2.http.Path


interface EvangelionApi {

    @GET("characters")
    suspend fun getCharacters(): List<Character>

    @GET("characters/{name}")
    suspend fun getCharacter(@Path("name") name: String): Character

}