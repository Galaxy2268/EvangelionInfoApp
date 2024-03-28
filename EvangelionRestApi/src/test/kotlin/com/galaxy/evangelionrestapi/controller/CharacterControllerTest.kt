package com.galaxy.evangelionrestapi.controller

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

private const val BASE_URL = "/api/characters"
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
            characterController.get(BASE_URL)
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
            characterController.get( "$BASE_URL/name/Asuka")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("Asuka") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getCharacterByIdEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetCharacterByIdEndpoint {
        @Test
        fun `should return a character by id`() {
            characterController.get("$BASE_URL/id/1")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("Asuka") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentCharacter(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentCharacterByName {
        @Test
        fun `should return is not found status`() {
            characterController.get("$BASE_URL/name/Does not exist")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentCharacter(id)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentCharacterById {
        @Test
        fun `should return is not found status`() {
            characterController.get("$BASE_URL/id/-1")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

}