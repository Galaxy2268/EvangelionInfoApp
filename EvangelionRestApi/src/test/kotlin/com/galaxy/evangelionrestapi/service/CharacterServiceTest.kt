package com.galaxy.evangelionrestapi.service

import com.galaxy.evangelionrestapi.web.service.CharacterService
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CharacterServiceTest {

    @Autowired
    private lateinit var service: CharacterService

    @Nested
    @DisplayName("getCharacters")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetCharacters {
        @Test
        fun `should return a list of characters`() {
            val characters = service.getCharacters()
            Assertions.assertTrue(characters.isNotEmpty())
        }
    }

    @Nested
    @DisplayName("getByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetByName {
        @Test
        fun `should return character by name`() {
            val character = service.getByName("Asuka")
            Assertions.assertTrue(character.name == "Asuka" && character.rank == "Second Child")
        }
    }

    @Nested
    @DisplayName("getByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetByPk {
        @Test
        fun `should return character by pk`() {
            val character = service.getByPk(1)
            Assertions.assertTrue(character.name == "Asuka" && character.rank == "Second Child")
        }
    }

    @Nested
    @DisplayName("picturePathTest")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PicturePathTest{
        @Test
        fun `should contain correct picture path`(){
            val characters = service.getCharacters()
            Assertions.assertTrue(characters[0].picture.contains("8080/pictures/"))
        }
    }

    @Nested
    @DisplayName("getNonExistentCharacter(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentCharacterByName {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByName("Does not exist")
            }
        }
    }

    @Nested
    @DisplayName("getNonExistentCharacter(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentCharacterByPk {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByPk(-1)
            }
        }
    }
}