package com.galaxy.evawiki.usecases

import com.galaxy.evawiki.evainfo.domain.model.Item
import com.galaxy.evawiki.evainfo.domain.usecases.GetItems
import com.galaxy.evawiki.evainfo.domain.usecases.util.ItemType
import com.galaxy.evawiki.repository.FakeItemRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetItemsTest {
    private lateinit var getItems: GetItems

    @Before
    fun setUp(){
        getItems = GetItems(FakeItemRepository())
    }

    @Test
    fun `Should return either with network error`() = runBlocking{
        getItems = GetItems(FakeItemRepository().apply { shouldReturnNetworkError = true })
        val response = getItems(ItemType.CharacterType)
        Truth.assertThat(response.isLeft()).isTrue()
    }

    @Test
    fun `Should return either with character items`(): Unit = runBlocking{
        val response = getItems(ItemType.CharacterType)
        Truth.assertThat(response.isLeft()).isFalse()
        val characters: List<Item>
        response.onRight {
            characters = it
            Truth.assertThat(characters[0]::class == Item.Character::class).isTrue()
        }
    }

    @Test
    fun `Should return either with evangelion items`(): Unit = runBlocking{
        val response = getItems(ItemType.EvangelionType)
        Truth.assertThat(response.isLeft()).isFalse()
        val evangelions: List<Item>
        response.onRight {
            evangelions = it
            Truth.assertThat(evangelions[0]::class == Item.Evangelion::class).isTrue()
        }
    }

    @Test
    fun `Should return either with episode items`(): Unit = runBlocking{
        val response = getItems(ItemType.EpisodeType)
        Truth.assertThat(response.isLeft()).isFalse()
        val episodes: List<Item>
        response.onRight {
            episodes = it
            Truth.assertThat(episodes[0]::class == Item.Episode::class).isTrue()
        }
    }

    @Test
    fun `Should return either with stuff items`(): Unit = runBlocking{
        val response = getItems(ItemType.StuffType)
        Truth.assertThat(response.isLeft()).isFalse()
        val stuffList: List<Item>
        response.onRight {
            stuffList = it
            Truth.assertThat(stuffList[0]::class == Item.Stuff::class).isTrue()
        }
    }

    @Test
    fun `Should return either with angel items`(): Unit = runBlocking{
        val response = getItems(ItemType.AngelType)
        Truth.assertThat(response.isLeft()).isFalse()
        val angels: List<Item>
        response.onRight {
            angels = it
            Truth.assertThat(angels[0]::class == Item.Angel::class).isTrue()
        }
    }
}