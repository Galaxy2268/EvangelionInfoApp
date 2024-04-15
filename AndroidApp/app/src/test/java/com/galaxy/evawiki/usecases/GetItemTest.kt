package com.galaxy.evawiki.usecases

import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.usecases.GetItem
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType
import com.galaxy.evawiki.repository.FakeItemRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetItemTest {

    private lateinit var getItem: GetItem

    @Before
    fun setUp(){
        getItem = GetItem(FakeItemRepository())
    }

    @Test
    fun `Should return either with network error`() = runBlocking{
        getItem = GetItem(FakeItemRepository().apply { shouldReturnNetworkError = true })
        val response = getItem(ItemType.CharacterType, 1)
        assertThat(response.isLeft()).isTrue()
    }

    @Test
    fun `Should return either with character item`(): Unit = runBlocking{
        val response = getItem(ItemType.CharacterType, 1)
        assertThat(response.isLeft()).isFalse()
        val character: Item
        response.onRight {
            character = it
            assertThat(character::class == Item.Character::class).isTrue()
        }
    }


}