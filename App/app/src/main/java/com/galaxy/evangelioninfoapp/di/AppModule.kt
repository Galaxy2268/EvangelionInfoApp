package com.galaxy.evangelioninfoapp.di

import com.galaxy.evangelioninfoapp.di.util.BaseUrl.BASE_URL
import com.galaxy.evangelioninfoapp.evangelioninfo.data.remote.EvangelionApi
import com.galaxy.evangelioninfoapp.evangelioninfo.data.repository.CharacterRepositoryImpl
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.repository.CharacterRepository
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.usecases.characters.CharacterUseCases
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.usecases.characters.GetCharacter
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.usecases.characters.GetCharacters
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
    fun provideEvangelionApi(): EvangelionApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EvangelionApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: EvangelionApi): CharacterRepository{
        return CharacterRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCharacterUseCases(repository: CharacterRepository): CharacterUseCases {
        return CharacterUseCases(
            getCharacters = GetCharacters(repository),
            getCharacter = GetCharacter(repository)
        )
    }


}