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

private const val BASE_URL = "/api/evangelions"
@SpringBootTest
@AutoConfigureMockMvc
internal class EvangelionControllerTest {

    @Autowired
    private lateinit var evangelionController: MockMvc

    @Nested
    @DisplayName("getEvangelionsEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEvangelionsEndpoint {
        @Test
        fun `should return a list of evangelion`() {
            evangelionController.get(BASE_URL)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$[0].name") { value("Unit-01") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getEvangelionByNameEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEvangelionByNameEndpoint {
        @Test
        fun `should return a evangelion by name`() {
            evangelionController.get( "$BASE_URL/name/Unit-01")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("Unit-01") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getEvangelionByIdEndpoint")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEvangelionByIdEndpoint {
        @Test
        fun `should return a evangelion by id`() {
            evangelionController.get("$BASE_URL/id/3")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    jsonPath("$.name") { value("Unit-02") }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentEvangelion(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentEvangelionByName {
        @Test
        fun `should return is not found status`() {
            evangelionController.get("$BASE_URL/name/Does not exist")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

    @Nested
    @DisplayName("getNonExistentEvangelion(id)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentEvangelionById {
        @Test
        fun `should return is not found status`() {
            evangelionController.get("$BASE_URL/id/-1")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }

        }
    }

}