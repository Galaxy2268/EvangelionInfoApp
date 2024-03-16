package com.galaxy.evangelionrestapi.controller

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class CharacterControllerTest {

    @Autowired
    private lateinit var characterController: MockMvc

    @Nested
    @DisplayName("getCharactersEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetCharactersEndpoint {
        @Test
        fun `should return a list of characters`() {
            characterController.get("/api/characters")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$[0].name") { value("Asuka") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getCharacterByNameEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetCharacterByNameEndpoint {
        @Test
        fun `should return a character by name`() {
            characterController.get("/api/characters/Asuka")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("Asuka") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentCharacter")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentCharacter {
        @Test
        fun `should return is not found status`() {
            characterController.get("/api/characters/Does not exist")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

}