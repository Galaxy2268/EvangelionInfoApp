package com.galaxy.evangelionrestapi.repository

import com.galaxy.evangelionrestapi.data.repository.CharacterRepository
import com.galaxy.evangelionrestapi.domain.model.Character
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class RepositoryTest {

    @Autowired
    private lateinit var repository: CharacterRepository
    @Nested
    @DisplayName("findAll")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindAll {
        @Test
        fun `should return a list of characters`() {
            val characters = repository.findAll()
            Assertions.assertTrue(characters.isNotEmpty())
        }
    }


    @Nested
    @DisplayName("findByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByName {
        @Test
        fun `should return character by name`() {
            val character = repository.findByName("Shinji")
            Assertions.assertTrue(character?.name == "Shinji" && character.age == 14)
        }
    }


    @Nested
    @DisplayName("findNonExistentCharacter")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentCharacter {
        @Test
        fun `should return null`() {
            val character = repository.findByName("Does not exist")
            Assertions.assertTrue(character == null)
        }
    }
}