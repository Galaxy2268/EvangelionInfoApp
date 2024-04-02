package com.galaxy.evawiki.evainfo.domain.model

sealed class Item{
    data class EvangelionItem(val evangelion: Evangelion): Item()
    data class CharacterItem(val character: Character): Item()
    data class AngelItem(val angel: Angel): Item()
    data class EpisodeItem(val episode: Episode): Item()
    data class StuffItem(val stuff: Stuff): Item()
}