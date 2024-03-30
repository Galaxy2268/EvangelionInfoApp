package com.galaxy.evangelionrestapi.controller

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

private const val BASE_URL = "/api/angels"
@SpringBootTest
@AutoConfigureMockMvc
internal class AngelControllerTest {

    @Autowired
    private lateinit var angelController: MockMvc

    @Nested
    @DisplayName("getAngelsEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAngelsEndpoint {
        @Test
        fun `should return a list of angels`() {
            angelController.get(BASE_URL)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getAngelByNameEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAngelByNameEndpoint {
        @Test
        fun `should return an angel by name`() {
            angelController.get("$BASE_URL/name/Adam")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("Adam") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getAngelByIdEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAngelByIdEndpoint {
        @Test
        fun `should return an angel by id`() {
            angelController.get("$BASE_URL/id/2")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("Lilith") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentAngel(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentAngelByName {
        @Test
        fun `should return is not found status`() {
            angelController.get("$BASE_URL/name/Does not exist")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentAngel(id)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentAngelById {
        @Test
        fun `should return is not found status`() {
            angelController.get("$BASE_URL/id/-1")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

}