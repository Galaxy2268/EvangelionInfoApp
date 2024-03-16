package com.galaxy.evangelionrestapi.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class PreviewControllerTest {
    @Autowired
    private lateinit var previewController: MockMvc

    @Test
    fun `should return preview text`(){
        previewController.get("/api")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { MediaType.valueOf("text/plain;charset=UTF-8") }
            }
    }
}