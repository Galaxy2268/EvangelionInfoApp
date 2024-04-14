package com.galaxy.evawiki.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.data.mapper.toNetworkError
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.ItemRepository
import java.io.IOException

class FakeItemRepository: ItemRepository {

    var shouldReturnNetworkError = false

    private val angel: Item.Angel = Item.Angel(1, "name", "meaning", "symbolism", 1, "info", "picture")
    private val angelList: List<Item.Angel> = listOf(angel)

    private val evangelion: Item.Evangelion = Item.Evangelion(1, "name", "model", "pilot", "soul", "info", "picture")
    private val evangelionList: List<Item.Evangelion> = listOf(evangelion)

    private val character: Item.Character = Item.Character(1, "name", "fullName", "rank", 1, "dateOfBirth", "bloodType", "bio", "picture")
    private val characterList: List<Item.Character> = listOf(character)

    private val episode: Item.Episode = Item.Episode(1, "number", "name", "director", "writer", "airDate", "info", "picture")
    private val episodeList: List<Item.Episode> = listOf(episode)

    private val stuff: Item.Stuff = Item.Stuff(1, "name", "info", "picture")
    private val stuffList: List<Item.Stuff> = listOf(stuff)

    override suspend fun getAngels(): Either<NetworkError, List<Item.Angel>> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(angelList)
        }
    }

    override suspend fun getAngel(id: Int): Either<NetworkError, Item.Angel> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(angel)
        }
    }


    override suspend fun getEvahgelions(): Either<NetworkError, List<Item.Evangelion>> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(evangelionList)
        }
    }

    override suspend fun getEvangelion(id: Int): Either<NetworkError, Item.Evangelion> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(evangelion)
        }
    }

    override suspend fun getCharacters(): Either<NetworkError, List<Item.Character>> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(characterList)
        }
    }

    override suspend fun getCharacter(id: Int): Either<NetworkError, Item.Character> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(character)
        }
    }

    override suspend fun getEpisodes(): Either<NetworkError, List<Item.Episode>> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(episodeList)
        }
    }

    override suspend fun getEpisode(id: Int): Either<NetworkError, Item.Episode> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(episode)
        }
    }

    override suspend fun getStuff(): Either<NetworkError, List<Item.Stuff>> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(stuffList)
        }
    }

    override suspend fun getSingleStuff(id: Int): Either<NetworkError, Item.Stuff> {
        return if (shouldReturnNetworkError){
            Either.Left(IOException().toNetworkError())
        }else{
            Either.Right(stuff)
        }
    }


}