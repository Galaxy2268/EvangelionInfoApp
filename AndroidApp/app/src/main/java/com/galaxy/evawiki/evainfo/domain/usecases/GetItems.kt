package com.galaxy.evawiki.evainfo.domain.usecases

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.ItemRepository
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType

class GetItems(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(itemType: ItemType): Either<NetworkError, List<Item>> {
        when(itemType){
            is ItemType.EvangelionType ->{
                return itemRepository.getEvahgelions()
            }
            is ItemType.EpisodeType -> {
                return itemRepository.getEpisodes()
            }
            is ItemType.AngelType -> {
                return itemRepository.getAngels()
            }
            is ItemType.CharacterType -> {
                return itemRepository.getCharacters()
            }
            is ItemType.StuffType ->{
                return itemRepository.getStuff()
            }
        }

    }
}