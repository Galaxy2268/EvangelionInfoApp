package com.galaxy.evawiki.evainfo.data.repository

import arrow.core.Either
import com.galaxy.evawiki.evainfo.data.mapper.toNetworkError
import com.galaxy.evawiki.evainfo.data.remote.EvangelionApi
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.ItemRepository

class ItemRepositoryImpl(
    private val api: EvangelionApi
): ItemRepository {

    override suspend fun getAngels(): Either<NetworkError, List<Item.Angel>> {
        return Either.catch {
            api.getAngels()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getAngel(id: Int): Either<NetworkError, Item.Angel> {
        return Either.catch {
            api.getAngel(id)
        }.mapLeft { it.toNetworkError() }
    }
    override suspend fun getEvahgelions(): Either<NetworkError, List<Item.Evangelion>> {
        return Either.catch {
            api.getEvangelions()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getEvangelion(id: Int): Either<NetworkError, Item.Evangelion> {
        return Either.catch {
            api.getEvangelion(id)
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getCharacters(): Either<NetworkError, List<Item.Character>> {
        return Either.catch {
            api.getCharacters()
        }.mapLeft { it.toNetworkError() }

    }

    override suspend fun getCharacter(id: Int): Either<NetworkError, Item.Character> {
        return Either.catch {
            api.getCharacter(id)
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getEpisodes(): Either<NetworkError, List<Item.Episode>> {
        return Either.catch {
            api.getEpisodes()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getEpisode(id: Int): Either<NetworkError, Item.Episode> {
        return Either.catch {
            api.getEpisode(id)
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getStuff(): Either<NetworkError, List<Item.Stuff>> {
        return Either.catch {
            api.getStuff()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getSingleStuff(id: Int): Either<NetworkError, Item.Stuff> {
        return Either.catch {
            api.getSingleStuff(id)
        }.mapLeft { it.toNetworkError() }
    }

}