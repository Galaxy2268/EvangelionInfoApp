package com.galaxy.evangelionrestapi.service

import com.galaxy.evangelionrestapi.web.service.StuffService
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class StuffServiceTest {

    @Autowired
    private lateinit var service: StuffService

    @Nested
    @DisplayName("getStuff")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetStuff {
        @Test
        fun `should return a list of stuff`() {
            val stuff = service.getStuff()
            Assertions.assertTrue(stuff.isNotEmpty())
        }
    }

    @Nested
    @DisplayName("getStuffByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetStuffByName {
        @Test
        fun `should return stuff by name`() {
            val stuff = service.geByName("Core")
            Assertions.assertTrue(stuff.name == "Core")
        }
    }

    @Nested
    @DisplayName("getStuffByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetStuffByPk {
        @Test
        fun `should return stuff by pk`() {
            val stuff = service.getByPk(2)
            Assertions.assertTrue(stuff.name == "S2-Engine")
        }
    }

    @Nested
    @DisplayName("getNonExistentStuff(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentStuffByName {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.geByName("Does not exist")
            }
        }
    }

    @Nested
    @DisplayName("getNonExistentStuff(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentStuffByPk {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByPk(-1)
            }
        }
    }
}