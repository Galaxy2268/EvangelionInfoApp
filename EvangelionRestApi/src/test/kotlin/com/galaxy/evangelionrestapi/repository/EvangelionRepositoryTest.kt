package com.galaxy.evangelionrestapi.repository

import com.galaxy.evangelionrestapi.data.repository.EvangelionRepository
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class EvangelionRepositoryTest {

    @Autowired
    private lateinit var repository: EvangelionRepository
    @Nested
    @DisplayName("findAll")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindAll {
        @Test
        fun `should return a list of evangelions`() {
            val evangelions = repository.findAll()
            Assertions.assertTrue(evangelions.isNotEmpty())
        }
    }


    @Nested
    @DisplayName("findByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByName {
        @Test
        fun `should return evangelion by name`() {
            val eva = repository.findByName("Unit-01")
            Assertions.assertTrue(eva?.name == "Unit-01" && eva.pilot == "Shinji Ikari")
        }
    }


    @Nested
    @DisplayName("findByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindByPk {
        @Test
        fun `should return evangelion by pk`() {
            val eva = repository.findByPk(2)
            Assertions.assertTrue(eva?.name == "Unit-00" && eva.soul == "Rei I")
        }
    }


    @Nested
    @DisplayName("findNonExistentEvangelion(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentEvangelionByName{
        @Test
        fun `should return null`() {
            val eva = repository.findByName("Does not exist")
            Assertions.assertTrue(eva == null)
        }
    }

    @Nested
    @DisplayName("findNonExistentEvangelion(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindNonExistentEvangelionByPk {
        @Test
        fun `should return null`() {
            val character = repository.findByPk(-1)
            Assertions.assertTrue(character == null)
        }
    }
}