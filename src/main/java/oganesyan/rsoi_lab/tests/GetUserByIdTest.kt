package oganesyan.rsoi_lab.tests

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetUserByIdTest {

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun getUserByIdTest() {
        val user = this.restTemplate?.getForObject<String>("http://localhost:8080/api/v1/persons/1");
        user?.let {
            println(
                "Get person from id=1: $it"
            )
        } ?: throw Exception()
    }
}