package com.galaxy.evawiki.di

import com.galaxy.evawiki.di.util.BaseUrl.BASE_URL
import com.galaxy.evawiki.evainfo.data.remote.EvangelionApi
import com.galaxy.evawiki.evainfo.data.repository.ItemRepositoryImpl
import com.galaxy.evawiki.evainfo.domain.repository.ItemRepository
import com.galaxy.evawiki.evainfo.domain.usecases.GetItem
import com.galaxy.evawiki.evainfo.domain.usecases.GetItems
import com.galaxy.evawiki.evainfo.domain.usecases.ItemUseCases
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
    fun provideItemRepository(api: EvangelionApi): ItemRepository {
        return ItemRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideCharacterUseCases(
        itemRepository: ItemRepository,
    ): ItemUseCases {
        return ItemUseCases(
            getItem = GetItem(itemRepository),
            getItems = GetItems(itemRepository),
        )
    }


}