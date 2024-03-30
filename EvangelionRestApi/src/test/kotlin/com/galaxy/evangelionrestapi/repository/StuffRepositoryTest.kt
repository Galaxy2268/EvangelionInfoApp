package com.galaxy.evangelionrestapi.repository



import com.galaxy.evangelionrestapi.data.repository.StuffRepository
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class StuffRepositoryTest {

    @Autowired
    private lateinit var repository: StuffRepository
    @Nested
    @DisplayName("findAll")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindAll {
        @Test
        fun `should return a list of stuff`() {
            val stuff = repository.findAll()
            Assertions.assertTrue(stuff.isNotEmpty())
        }
    }


    @Nested
    @DisplayName("findByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByName {
        @Test
        fun `should return stuff by name`() {
            val stuff = repository.findByName("S2-Engine")
            Assertions.assertTrue(stuff?.name == "S2-Engine")
        }
    }


    @Nested
    @DisplayName("findByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByPk {
        @Test
        fun `should return stuff by pk`() {
            val stuff = repository.findByPk(1)
            Assertions.assertTrue(stuff?.name == "Core")
        }
    }


    @Nested
    @DisplayName("findNonExistentStuff(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentStuffByName{
        @Test
        fun `should return null`() {
            val stuff = repository.findByName("Does not exist")
            Assertions.assertTrue(stuff == null)
        }
    }

    @Nested
    @DisplayName("findNonExistentStuff(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentStuffByPk {
        @Test
        fun `should return null`() {
            val stuff = repository.findByPk(-1)
            Assertions.assertTrue(stuff == null)
        }
    }
}