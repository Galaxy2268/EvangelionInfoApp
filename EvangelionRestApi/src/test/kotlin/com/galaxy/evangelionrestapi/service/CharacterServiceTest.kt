package com.galaxy.evangelionrestapi.service

import com.galaxy.evangelionrestapi.web.service.CharacterService
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CharacterServiceTest {

    @Autowired
    private lateinit var characterService: CharacterService

    @Nested
    @DisplayName("getCharacters")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetCharacters {
        @Test
        fun `should return a list of characters`() {
            val characters = characterService.getCharacters()
            Assertions.assertTrue(characters.isNotEmpty())
        }
    }

    @Nested
    @DisplayName("getByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetByName {
        @Test
        fun `should return character by name`() {
            val character = characterService.getByName("Asuka")
            Assertions.assertTrue(character.name == "Asuka" && character.rank == "Second Child")
        }
    }

    @Nested
    @DisplayName("getById")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetById {
        @Test
        fun `should return character by id`() {
            val character = characterService.getById(1)
            Assertions.assertTrue(character.name == "Asuka" && character.rank == "Second Child")
        }
    }

    @Nested
    @DisplayName("getNonExistentCharacter(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentCharacterByName {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                characterService.getByName("Does not exist")
            }
        }
    }

    @Nested
    @DisplayName("getNonExistentCharacter(id)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentCharacterById {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                characterService.getById(-1)
            }
        }
    }
}