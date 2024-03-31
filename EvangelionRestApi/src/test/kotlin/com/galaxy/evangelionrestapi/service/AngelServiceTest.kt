package com.galaxy.evangelionrestapi.service


import com.galaxy.evangelionrestapi.web.service.AngelService
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class AngelServiceTest {

    @Autowired
    private lateinit var service: AngelService

    @Nested
    @DisplayName("getAngels")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAngels {
        @Test
        fun `should return a list of angels`() {
            val angels = service.getAngels()
            Assertions.assertTrue(angels.isNotEmpty())
        }
    }

    @Nested
    @DisplayName("getByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetByName {
        @Test
        fun `should return angel by name`() {
            val angel = service.getByName("Adam")
            Assertions.assertTrue(angel.name == "Adam" && angel.number == 1)
        }
    }

    @Nested
    @DisplayName("getByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetByPk {
        @Test
        fun `should return angel by pk`() {
            val angel = service.getByPk(2)
            Assertions.assertTrue(angel.name == "Lilith" && angel.number == 2)
        }
    }

    @Nested
    @DisplayName("picturePathTest")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PicturePathTest{
        @Test
        fun `should contain correct picture path`(){
            val angel = service.getByPk(1)
            Assertions.assertTrue(angel.picture.contains("8080/pictures/"))
        }
    }

    @Nested
    @DisplayName("getNonExistentAngel(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentAngelByName {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByName("Does not exist")
            }
        }
    }

    @Nested
    @DisplayName("getNonExistentAngel(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentAngelByPk {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByPk(-1)
            }
        }
    }
}