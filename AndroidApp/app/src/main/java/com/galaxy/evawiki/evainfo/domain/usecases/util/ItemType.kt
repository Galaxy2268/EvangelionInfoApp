package com.galaxy.evawiki.evainfo.domain.usecases.util

sealed class ItemType {
    data object EvangelionType: ItemType()

    data object AngelType: ItemType()

    data object CharacterType: ItemType()

    data object StuffType: ItemType()

    data object EpisodeType: ItemType()

}