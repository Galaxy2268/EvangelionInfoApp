package com.galaxy.evawiki.evainfo.domain.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.model.NetworkError


interface ItemRepository {

    suspend fun getAngels(): Either<NetworkError, List<Item.Angel>>

    suspend fun getAngel(id: Int): Either<NetworkError, Item.Angel>

    suspend fun getEvahgelions(): Either<NetworkError, List<Item.Evangelion>>

    suspend fun getEvangelion(id: Int): Either<NetworkError, Item.Evangelion>

    suspend fun getCharacters(): Either<NetworkError, List<Item.Character>>

    suspend fun getCharacter(id: Int): Either<NetworkError, Item.Character>

    suspend fun getEpisodes(): Either<NetworkError, List<Item.Episode>>

    suspend fun getEpisode(id: Int): Either<NetworkError, Item.Episode>

    suspend fun getStuff(): Either<NetworkError, List<Item.Stuff>>

    suspend fun getSingleStuff(id: Int): Either<NetworkError, Item.Stuff>

}