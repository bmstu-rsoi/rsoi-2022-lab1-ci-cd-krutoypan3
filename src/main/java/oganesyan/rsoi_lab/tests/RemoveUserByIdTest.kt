package oganesyan.rsoi_lab.tests

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RemoveUserByIdTest {

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun removeUserByIdTest() {
        this.restTemplate?.delete("http://localhost:8080/api/v1/persons/1")
    }
}
