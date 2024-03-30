package com.galaxy.evangelionrestapi.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

private const val BASE_URL = "/api/stuff"
@SpringBootTest
@AutoConfigureMockMvc
internal class StuffControllerTest {

    @Autowired
    private lateinit var stuffController: MockMvc

    @Nested
    @DisplayName("getStuffEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetStuffEndpoint {
        @Test
        fun `should return a list of stuff`() {
            stuffController.get(BASE_URL)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getStuffByNameEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetStuffByNameEndpoint {
        @Test
        fun `should return stuff by name`() {
            stuffController.get("$BASE_URL/name/Core")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("Core") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getStuffByIdEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetStuffByIdEndpoint {
        @Test
        fun `should return stuff by id`() {
            stuffController.get("$BASE_URL/id/2")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("S2-Engine") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentStuff(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentStuffByName {
        @Test
        fun `should return is not found status`() {
            stuffController.get("$BASE_URL/name/Does not exist")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentStuff(id)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentStuffById {
        @Test
        fun `should return is not found status`() {
            stuffController.get("$BASE_URL/id/-1")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

}