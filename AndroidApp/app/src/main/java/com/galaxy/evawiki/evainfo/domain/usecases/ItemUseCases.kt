package com.galaxy.evawiki.evainfo.domain.usecases

import com.galaxy.evawiki.evainfo.domain.usecases.angel.GetAngel
import com.galaxy.evawiki.evainfo.domain.usecases.angel.GetAngels
import com.galaxy.evawiki.evainfo.domain.usecases.character.GetCharacter
import com.galaxy.evawiki.evainfo.domain.usecases.character.GetCharacters
import com.galaxy.evawiki.evainfo.domain.usecases.episode.GetEpisode
import com.galaxy.evawiki.evainfo.domain.usecases.episode.GetEpisodes
import com.galaxy.evawiki.evainfo.domain.usecases.evangelion.GetEvangelion
import com.galaxy.evawiki.evainfo.domain.usecases.evangelion.GetEvangelions
import com.galaxy.evawiki.evainfo.domain.usecases.stuff.GetSingleStuff
import com.galaxy.evawiki.evainfo.domain.usecases.stuff.GetStuff

data class ItemUseCases(
    val getCharacters: GetCharacters,
    val getCharacter: GetCharacter,
    val getAngel: GetAngel,
    val getAngels: GetAngels,
    val getEpisode: GetEpisode,
    val getEpisodes: GetEpisodes,
    val getEvangelion: GetEvangelion,
    val getEvangelions: GetEvangelions,
    val getSingleStuff: GetSingleStuff,
    val getStuff: GetStuff
)