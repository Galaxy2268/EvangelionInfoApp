package com.galaxy.evangelionrestapi.repository

import com.galaxy.evangelionrestapi.data.repository.AngelRepository
import com.galaxy.evangelionrestapi.data.repository.EvangelionRepository
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class AngelRepositoryTest {

    @Autowired
    private lateinit var repository: AngelRepository
    @Nested
    @DisplayName("findAll")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindAll {
        @Test
        fun `should return a list of angels`() {
            val angels = repository.findAll()
            Assertions.assertTrue(angels.isNotEmpty())
        }
    }


    @Nested
    @DisplayName("findByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByName {
        @Test
        fun `should return angel by name`() {
            val angel = repository.findByName("Lilith")
            Assertions.assertTrue(angel?.name == "Lilith" && angel.number == 2)
        }
    }


    @Nested
    @DisplayName("findByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByPk {
        @Test
        fun `should return angel by pk`() {
            val angel = repository.findByPk(1)
            Assertions.assertTrue(angel?.name == "Adam" && angel.number == 1)
        }
    }


    @Nested
    @DisplayName("findNonExistentAngel(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentAngelByName{
        @Test
        fun `should return null`() {
            val angel = repository.findByName("Does not exist")
            Assertions.assertTrue(angel == null)
        }
    }

    @Nested
    @DisplayName("findNonExistentAngel(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentAngelByPk {
        @Test
        fun `should return null`() {
            val angel = repository.findByPk(-1)
            Assertions.assertTrue(angel == null)
        }
    }
}