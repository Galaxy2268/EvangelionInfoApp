package com.galaxy.evangelionrestapi.service



import com.galaxy.evangelionrestapi.web.service.EvangelionService
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class EvangelionServiceTest {

    @Autowired
    private lateinit var service: EvangelionService

    @Nested
    @DisplayName("getEvangelions")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetEvangelions {
        @Test
        fun `should return a list of evangelions`() {
            val evangelions = service.getEvangelions()
            Assertions.assertTrue(evangelions.isNotEmpty())
        }
    }

    @Nested
    @DisplayName("getByName")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetByName {
        @Test
        fun `should return evangelion by name`() {
            val eva = service.getByName("Unit-01")
            Assertions.assertTrue(eva?.name == "Unit-01" && eva.pilot == "Shinji Ikari")
        }
    }

    @Nested
    @DisplayName("getByPk")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetByPk {
        @Test
        fun `should return evangelion by pk`() {
            val eva = service.getByPk(2)
            Assertions.assertTrue(eva.name == "Unit-00" && eva.soul == "Rei I")
        }
    }

    @Nested
    @DisplayName("getNonExistentEvangelion(name)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentEvangelionByName {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByName("Does not exist")
            }
        }
    }

    @Nested
    @DisplayName("getNonExistentEvangelion(pk)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetNonExistentEvangelionByPk {
        @Test
        fun `should throw null pointer exception`() {
            Assertions.assertThrows(NullPointerException::class.java) {
                service.getByPk(-1)
            }
        }
    }
}