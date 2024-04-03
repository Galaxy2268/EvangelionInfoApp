package com.galaxy.evawiki.evainfo.domain.usecases

import arrow.core.Either
import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.model.NetworkError
import com.galaxy.evawiki.evainfo.domain.repository.ItemRepository
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType

class GetItem(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(itemType: ItemType, id: Int): Either<NetworkError, Item>{
        when(itemType){
            is ItemType.EvangelionType ->{
                return itemRepository.getEvangelion(id)
            }
            is ItemType.EpisodeType -> {
                return itemRepository.getEpisode(id)
            }
            is ItemType.AngelType -> {
                return itemRepository.getAngel(id)
            }
            is ItemType.CharacterType -> {
                return itemRepository.getCharacter(id)
            }
            is ItemType.StuffType ->{
                return itemRepository.getSingleStuff(id)
            }
        }

    }
}