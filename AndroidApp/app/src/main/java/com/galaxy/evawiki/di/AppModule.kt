package com.galaxy.evawiki.di

import com.galaxy.evawiki.di.util.BaseUrl.BASE_URL
import com.galaxy.evawiki.evainfo.data.remote.EvangelionApi
import com.galaxy.evawiki.evainfo.data.repository.AngelRepositoryImpl
import com.galaxy.evawiki.evainfo.data.repository.CharacterRepositoryImpl
import com.galaxy.evawiki.evainfo.data.repository.EpisodeRepositoryImpl
import com.galaxy.evawiki.evainfo.data.repository.EvangelionRepositoryImpl
import com.galaxy.evawiki.evainfo.data.repository.StuffRepositoryImpl
import com.galaxy.evawiki.evainfo.domain.repository.AngelRepository
import com.galaxy.evawiki.evainfo.domain.repository.CharacterRepository
import com.galaxy.evawiki.evainfo.domain.repository.EpisodeRepository
import com.galaxy.evawiki.evainfo.domain.repository.EvangelionRepository
import com.galaxy.evawiki.evainfo.domain.repository.StuffRepository
import com.galaxy.evawiki.evainfo.domain.usecases.ItemUseCases
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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEvangelionApi(): EvangelionApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EvangelionApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: EvangelionApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideEvangelionRepository(api: EvangelionApi): EvangelionRepository {
        return EvangelionRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAngelRepository(api: EvangelionApi): AngelRepository {
        return AngelRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideEpisodeRepository(api: EvangelionApi): EpisodeRepository {
        return EpisodeRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideStuffRepository(api: EvangelionApi): StuffRepository {
        return StuffRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCharacterUseCases(
        characterRepository: CharacterRepository,
        angelRepository: AngelRepository,
        evangelionRepository: EvangelionRepository,
        episodeRepository: EpisodeRepository,
        stuffRepository: StuffRepository
    ): ItemUseCases {
        return ItemUseCases(
            getCharacters = GetCharacters(characterRepository),
            getCharacter = GetCharacter(characterRepository),
            getAngel = GetAngel(angelRepository),
            getAngels = GetAngels(angelRepository),
            getEvangelion = GetEvangelion(evangelionRepository),
            getEvangelions = GetEvangelions(evangelionRepository),
            getEpisode = GetEpisode(episodeRepository),
            getEpisodes = GetEpisodes(episodeRepository),
            getStuff = GetStuff(stuffRepository),
            getSingleStuff = GetSingleStuff(stuffRepository)
        )
    }


}